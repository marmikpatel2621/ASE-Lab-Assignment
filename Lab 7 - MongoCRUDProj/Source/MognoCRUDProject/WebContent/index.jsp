<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html ng-app="SocialLoginDemo" ng-controller="SocialLoginController">
<head >
<title>The Facebook-Twitter-Google-Login</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Rokkitt' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<style type="text/css">
		.site-bg {
			position: fixed;
			height: 100%;
			width: 100%;
			z-index: 0;
			background-image: url(/images/bg.jpg);
			background-size: cover;
			background-repeat: no-repeat;
			background-attachment: fixed;
		}

		.site-bg-overlay {
			position: fixed;
			width: 100%;
			height: 100%;
			top: 0;
			left: 0;
			z-index: 1;
			background: rgba(92, 180, 142, 0.4);
		}

	</style>
</head>
<body>


<div class="wrap">
<!-- strat-contact-form -->	
<div class="contact-form">
<!-- start-form -->
	<form class="contact_form" action="login.do" method="post" name="contact_form">
		<h1>Login Into Your Account</h1>
	    <ul>
	        <li>
	            <input type="email" class="textbox1" name="email" placeholder="example@mail.com" required />
	            <span class="form_hint">Enter a valid email</span>
	             <p><img src="images/contact.png" alt=""></p>
	        </li>
	        <li>
	            <input type="password" name="password" class="textbox2" placeholder="password" required>
	            <p><img src="images/lock.png" alt=""></p>
	        </li>
         </ul>
       	 	<input type="submit" name="Sign In" value="Sign In"/>
			<div class="clear"></div>	
			<label class="checkbox"><input type="checkbox" name="checkbox" checked><i></i>Remember me</label>
		<div class="forgot">
			<a href="#">forgot password?</a>
		</div>	
		<div class="clear"></div>	
	</form>
<!-- end-form -->
<!-- start-account -->
<div class="account">
	<div id="fb-root"></div>
	<h2><a href="signup.jsp">Don' have an account? Sign Up!</a></h2>
    <div class="span"><a href="#" ng-click="login()"><img src="images/facebook.png" alt=""/><i>Sign In with Facebook</i><div class="clear"></div></a></div>
   <div class="span2"><a href="#" ng-click="authenticate()"><img src="images/gplus.png" alt=""/><i>Sign In with Google+</i><div class="clear"></div></a></div></div>
<!--
    <button ng-click="getLoginStatus()">Get Facebook Status</button>
    <br>
    <button ng-click="logout()">Facebook Logout</button>
    <br>
    <button ng-click="getInfo()">Get info</button>
    <hr>
    <button ng-click="unsubscribe()">unsubscribe</button>
    <hr>-->


	<div ng-show="accessToken" style="display: none">
		<h1>You're authenticated!</h1>

		<h2>Access token</h2>
		<pre>{{accessToken}}</pre>

		<div ng-show="expiresIn">
			<h2>Expiry</h2>
			<p>Expires in {{expiresIn}} seconds.</p>
		</div>
	</div>
<!-- end-account -->
<div class="clear"></div>	
</div>
<!-- end-contact-form -->
<div class="footer">
	
</div>
</div>

<script type="text/javascript" src="http://code.angularjs.org/1.1.1/angular.js"></script>
<script type="text/javascript" src="http://code.angularjs.org/1.1.1/angular-resource.js"></script>
<script type="text/javascript" src="http://code.angularjs.org/1.1.1/angular-sanitize.js"></script>
<script type="text/javascript" src="js/services.js"></script>
<script src="js/index.js"></script>
<script src="js/googleOauth.js"></script>
<script src="js/angularOauth.js"></script>

</body>
<!--<script>
    window.fbAsyncInit = function() {
        FB.init({
            appId      : '1722170298006385',
            xfbml      : true,
            version    : 'v2.4'
        });
    };

    (function(d, s, id){
            console.log("heloo scrie");
            var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) {return;}
        js = d.createElement(s); js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));
</script>-->

</html>