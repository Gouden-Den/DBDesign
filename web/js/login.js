function trim(s){
    return s.replace(/^\s*|\s*$/g, "");
}

function $o(s){
    return document.getElementById(s);
}

var Tip={
	id:"p_tips",
	show:function(s){
		var o=$o(this.id);
		o.innerHTML=s+" <span onclick='Tip.hide()'>[隐藏]</span>";
		o.style.display='block';
	},
	hide:function(){
		$o(this.id).style.display='none';
	}
}

var Web = {
    checkFormField: function(f, name, msg, name2){
        if (trim(f[name].value).length == 0) {
            Tip.show(msg);
            if (typeof(name2) == 'undefined') {
                name2 = name;
            }
            f[name2].focus();
            return false;
        };
        return true;
    },
    checkForm: function(f){
        if (!this.checkFormField(f, 'p_username', '抱歉，用户名不能为空！')) {
            return false;
        }
        if (!this.checkFormField(f, 'p_password', '抱歉，密码不能为空！')) {
            return false;
        }
        if (trim(f.p_imgcode.value) == '' || f.p_imgcode.value.length != 4) {
            Tip.show('抱歉，验证码非法！请输入4位的字符！');
            f.p_imgcode.focus();
            return false;
        }
        return true;
    },
		changeImgCode:function(){
			$o('imgcode').src='code.html?_='+Math.random();
		},
    doLogin: function(f){
        var f = document.myform;
        if (this.checkForm(f)) {
            $o('p_fw').innerHTML = '<iframe id="df" name="df" style="display:none;width:1px;height:1px;" width=1 height=1><iframe>';
            f.target = "df";
            f.action = 'login.html';
						return true;
        }
				return false;
    },
    doCallback: function(o){
        if (o.cmd== 'login') {
            if (o.status == 'true') {
                    location.href = 'index.html';
            }
            else {
                if (o.msg == 'errorImgCode') {
                    Tip.show("抱歉，登录失败！您输入的验证码错误！");
                }
                else {
                    Tip.show("抱歉，登录失败！您输入的用户名或密码有误！");
                }
            }
        }
    }
}
