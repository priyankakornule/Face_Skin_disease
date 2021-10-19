<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

 <link rel="stylesheet" href="forgetPassCss/font-awesome.min.css">
<body data-gr-c-s-loaded="true" style="
    background-color: skyblue;
">
<script type="text/javascript">
	function check_pass() {
		if (document.getElementById('pass').value == document.getElementById('confirm_pass').value) {
			document.getElementById('submit').disabled = false;
			document.getElementById('mesage').innerHTML="Password Matched";
		} else {
			document.getElementById('submit').disabled = true;
			document.getElementById('mesage').innerHTML="Password do not matched";
		};
	}
	
   </script>
 <div class="form-gap"></div>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
           <div class="panel panel-default" style="
    margin-top: 15%;
">
              <div class="panel-body">
                <div class="text-center">
                  <h3><i class="fa fa-lock fa-4x"></i></h3>
                  <h2 class="text-center">Forgot Password?</h2>
                  <p>You can reset your password here.</p>
                  <div class="panel-body">
    
                    <form action="ResetController" id="register-form" role="form" autocomplete="off" class="form" method="post">
    
                      <div class="form-group">
                        <div class="input-group">
                          <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                          <input id="pass" name="pass" placeholder="Enter Password" class="form-control"  type="text" onkeyup='check_pass();' required="true" minlength="8">
                        </div>
                        </div>
                        <div class="form-group">
                         <div class="input-group">
                          <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                          <input id="confirm_pass" name="confirm_pass" placeholder="Enter Confirm Password" class="form-control"  type="text"onkeyup='check_pass();' required="true" minlength="8">
                        </div>
                      </div>
                      <div class="form-group">
                        <input name="recover-submit" class="btn btn-lg btn-primary btn-block" value="Reset Password" type="submit">
                      </div>
                      
                      <input type="hidden" class="hide" name="token" id="token" value=""> 
                    </form>
    
                  </div>
                </div>
              </div>
            </div>
          </div>
	</div>
</div>
</body>