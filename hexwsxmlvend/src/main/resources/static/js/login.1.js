$(function(){

	// input iCheck
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
    
	// login Form Valid
	var loginFormValid = $("#loginForm").validate({
		errorElement : 'span',  
        errorClass : 'help-block',
        focusInvalid : true,  
        rules : {
            AgentNo : {
        		required : true ,
                minlength: 6,
                maxlength: 8
            },
            PassWord : {
            	required : true ,
                minlength: 8,
                maxlength: 12
            } 
        }, 
        messages : {
            AgentNo : {
                required  : "AgentNo cannot be null",
                minlength : "AgentNo too short"
            },
            PassWord : {
            	required  : "PassWord cannot be null",
                minlength : "PassWord too short"
                /*,maxlength:"登录密码不应超过18位"*/
            }
        }, 
		highlight : function(element) {  
            $(element).closest('.form-group').addClass('has-error');  
        },
        success : function(label) {  
            label.closest('.form-group').removeClass('has-error');  
            label.remove();  
        },
        errorPlacement : function(error, element) {  
            element.parent('div').append(error);  
        },
        submitHandler : function(form) {
			$.post(base_url + "/login", $("#loginForm").serialize(), function(data, status) {
				if (data.code == "200") {
                    layer.msg( I18n.login_success );
                    setTimeout(function(){
                        window.location.href = base_url;
                    }, 500);
				} else {
                    layer.open({
                        title: "System message",
                        btn: [ "Confirm" ],
                        content: (data.msg || "login failed" ),
                        icon: '2'
                    });
				}
			});
		}
	});
});