(function($) {
    function crateCommentInfo(obj) {
        if(typeof(obj.t_time) == "undefined" || obj.t_time == "") {
			obj.t_time = getNowDateFormat();
		}
		var el = "<div class='comment-info'><header><img src='" + obj.t_img + "'></header><div class='comment-right'><h3>" + obj.t_name + "</h3>" +
			"<div class='comment-content-header'><span><i class='glyphicon glyphicon-time'></i>" + obj.t_time + "</span>";
		if(typeof(obj.t_browse) != "undefined" && obj.t_browse != "") {
			el = el + "<span><i class='glyphicon glyphicon-map-marker'></i>" + obj.t_browse + "</span>";
		}
		el = el + "</div><p class='content'>" + obj.t_text + "</p><div class='comment-content-footer'><div class='row'><div class='col-md-10'>";
		if(typeof(obj.t_osname) != "undefined" && obj.t_osname != "") {
			el = el + "<span><i class='glyphicon glyphicon-pushpin'></i> 来自:" + obj.t_osname + "</span>";
		}
		if(typeof(obj.t_browse) != "undefined" && obj.t_browse != "") {
			el = el + "<span><i class='glyphicon glyphicon-globe'></i> " + obj.t_browse + "</span class='my_id'>"+"<span>" + obj.t_id + "</span>";
		}
		el = el + "</div><div class='col-md-2'><span class='reply-btn'>回复</span></div></div></div><div class='reply-list'>";
		if(obj.ccom != "" && obj.ccom.length > 0) {
			var arr = obj.ccom;
			for(var j = 0; j < arr.length; j++) {
				var replyObj = arr[j];
				el = el + createReplyComment(replyObj);
			}
		}
		el = el + "</div></div></div>";
		return el;
	}

	function createReplyComment(reply) {
		// if($(".reply-list>div").eq(0).text()==""||$(".reply-list>div").eq(0).text()=="null"||$(".reply-list>div").eq(0).text()==null){
		// 	var replyEl = "<div class='reply'><div><a href='javascript:void(0)' class='replyname'>" + reply.replyName + "</a>:<a href='javascript:void(0)'>@" + reply.beReplyName + "</a><span>" + reply.content + "</span></div>" +
		// 		"<p><span>" + reply.time + "</span> <span class='reply-list-btn'>回复</span></p></div>";
		// }else{

        // console.log($(".reply").parent().children("h3").text())
        // alert(reply.t_name)
			var replyEl = "<div class='reply'><div><a href='javascript:void(0)' class='replyname'>" + reply.c_name + "</a>:<a href='javascript:void(0)'>@" + reply.t_name + "</a><span>" + reply.c_text + "</span></div>" +
				"<p><span>" + reply.c_time + "</span> <span class='reply-list-btn'>回复</span></p></div>";
		// }
		return replyEl;
	}

	function getNowDateFormat() {
		var nowDate = new Date();
		var year = nowDate.getFullYear();
		var month = filterNum(nowDate.getMonth() + 1);
		var day = filterNum(nowDate.getDate());
		var hours = filterNum(nowDate.getHours());
		var min = filterNum(nowDate.getMinutes());
		var seconds = filterNum(nowDate.getSeconds());
		return year + "-" + month + "-" + day + " " + hours + ":" + min + ":" + seconds;
	}

	function filterNum(num) {
		if(num < 10) {
			return "0" + num;
		} else {
			return num;
		}
	}

	function replyClick(el) {
		el.parent().parent().append("<div class='replybox'><textarea cols='80' rows='50' placeholder='来说几句吧......' class='mytextarea' ></textarea><span class='send'>发送</span></div>").find(".send").click(function() {
			var content = $(this).prev().val();
			if($.cookie("username")=="null"){
				alert("登录后才可以回复");
			}else {
				if (content != "") {
					var parentEl = $(this).parent().parent().parent().parent();
                    var a= parentEl.find(".col-md-10").children("span").text().length-1;
					var obj = new Object();
					obj.c_name = $(".a_name").text();
					if (el.parent().parent().hasClass("reply")) {
						//儿子的儿子
						var C_com = {
							"c_name": obj.c_name,
							"c_time": getNowDateFormat(),
							"c_text": content,
							"c_class": 1,
							"t_id": parentEl.find(".col-md-10").children("span").text().substring(a),
                            "t_name":el.parent().parent().find("a:first").text()
						}
						$.ajax({
							type: "post",
							url: "Ccom",
							data: JSON.stringify(C_com),
							contentType: "application/json;charset=utf-8",
							success: function (data) {
								obj.t_name = el.parent().parent().find("a:first").text();
							},
							error: function (data) {
								alert("发送失败")
							}
						})
						// }
					} else {
						//儿子
							var C_com = {
								"c_name": obj.c_name,
								"c_time": getNowDateFormat(),
								"c_text": content,
								"c_class": 2,
								"t_id": parentEl.find(".col-md-10").children("span").text().substring(a),
                                "t_name":parentEl.find("h3").text()
							}
							$.ajax({
								type: "post",
								url: "Ccom",
								data: JSON.stringify(C_com),
								contentType: "application/json;charset=utf-8",
								success: function (data) {
									obj.t_name = parentEl.find("h3").text();
								},
								error: function (data) {
									alert("发送失败")
								}
							})
					}
					obj.c_text = content;
					obj.c_time = getNowDateFormat();
					obj.t_name=$.cookie("username");
					var replyString = createReplyComment(obj);
					$(".replybox").remove();
					parentEl.find(".reply-list").append(replyString).find(".reply-list-btn:last").click(function () {
						alert("不能回复自己");
					});
				} else {
					alert("空内容");
				}
			}
		});
	}
	$.fn.addCommentList = function(options) {
		var defaults = {
			data: [],
			add: ""
		}
		var option = $.extend(defaults, options);
		if(option.data.length > 0) {
			var dataList = option.data;
			var totalString = "";
			for(var i = 0; i < dataList.length; i++) {
				var obj = dataList[i];
				var objString = crateCommentInfo(obj);
				totalString = totalString + objString;
			}
			$(this).append(totalString).find(".reply-btn").click(function() {
				if($(this).parent().parent().find(".replybox").length > 0) {
					$(".replybox").remove();
				} else {
					$(".replybox").remove();
					replyClick($(this));
				}
			});
			$(".reply-list-btn").click(function() {
				if($(this).parent().parent().find(".replybox").length > 0) {
					$(".replybox").remove();
				} else {
					$(".replybox").remove();
					replyClick($(this));
				}
			})
		}
		if(option.add != "") {
			obj = option.add;
			var str = crateCommentInfo(obj);
			$(this).prepend(str).find(".reply-btn").click(function() {
				replyClick($(this));
			});
		}
	}
})(jQuery);