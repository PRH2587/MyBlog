jQuery.handleError = jQuery.handleError
		|| function(s, xhr, status, e) {
			if (s.error) {
				s.error.call(s.context || s, xhr, status, e);
			}
			if (s.global) {
				(s.context ? jQuery(s.context) : jQuery.event).trigger(
						"ajaxError", [ xhr, s, e ]);
			}
		};

window.imageRepositoryUpload = function(ele,call) {
	function prepareUpload() {
		var q = $.Deferred();
		var form = $('<form method="post"></form>')
        	.append('<input name="file" id="imageUploadFile" type="file"/>');
		var _fileInput = form.find("#imageUploadFile");
		//var key = UUIDjs.create().toString();
		_fileInput.change(function(){
			if($(this).val()!=null && $(this).val()!=''){
				if(!/.(jpg|jpeg|png|jpg|png)$/.test($(_fileInput).val())){   
					$.msg("图片类型必须是,jpeg,jpg,png中的一种",'danger');
					return false;   
				}
				$.ajaxFileUpload({
					url : _path + '/repository/upload',
					type : "post",
					secureuri : false,
					fileElement : _fileInput,
					success : function(data, status) {
						var jsonString = $(data).text();
						var _data = eval("("+jsonString+")");
						if(_data.status == 200){
							var url = _data.data;
							var isEdit = false;
							if (ele.find('img').attr('src')) {
								isEdit = true;
							}
							ele.find('img').attr('src', url);
							ele.find('input').val(url);
							ele.find('.plus').addClass('hide');
							ele.find('.remove').removeClass('hide');
							ele.find('.plusText').addClass('hide');
						}
						q.resolve();
					},
					error : function(data, status, e) {
						q.resolve();
					}
				});
			}
		});
		_fileInput.click();
		return q.promise();
	};

	$.when(prepareUpload())
		.then(function() {	
		call();
	});
};