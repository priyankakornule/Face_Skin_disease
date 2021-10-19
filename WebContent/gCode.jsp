<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Adult Energy Needs and BMI Calculator</title>
        <meta charset="utf-8">  <meta name="viewport" content="width=device-width, initial-scale=1.0" >    
        <link rel="stylesheet" href="https://cloud.typography.com/6048112/786144/css/fonts.css">
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://media.bcm.edu/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://media.bcm.edu/theme/Paleo-ignite/css/shared.css">
        <link rel="stylesheet" href="https://media.bcm.edu/theme/Paleo-ignite/css/content-page.css">
        <link rel="stylesheet" href="https://media.bcm.edu/css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="https://media.bcm.edu/css/datepicker.css">
        <link rel="stylesheet" href="https://media.bcm.edu/css/default.css">
        
        <meta name="keywords" content="about us, healthcare" >

        <meta property="og:description" content="[describe here]" >
        <meta property="fb:app_id" content="673955425950836" >
        <meta property="og:image" content="https://media.bcm.edu/images/desktop/logo.png" >
        <meta property="og:image:secure_url" content="https://media.bcm.edu/images/desktop/logo.png" >
        <meta property="og:site_name" content="Baylor College of Medicine" >
     
        <meta property="og:type" content="website" >
        <meta property="og:url" content="[url here]" >
        <link rel="stylesheet" href="https://media.bcm.edu/themes/oneweb/css/content-page.css">    
        <script src="https://media.bcm.edu/js/google-fonts.js"></script>
        <script src="https://media.bcm.edu/js/spin.min.js"></script>
        <!-- COLDFUSION JAVASCRIPT START -->
        <script language="javascript" src="/scripts/mask.js"></script>
        <script language='javascript' src='/scripts/main.js'></script>
        <!-- COLDFUSION JAVASCRIPT END -->
        
        <link rel="shortcut icon" href="https://www.bcm.edu/favicon.ico?v=1.0.10" />
        <link rel="icon" type="image/png" href="https://www.bcm.edu/favicon.png?v=1.0.10" />
        <!--[if IE 8]><link href="https://media.bcm.edu/css/site.ie8.css" type="text/css" rel="stylesheet" /><![endif]-->
        <!--[if IE 7]><link href="https://media.bcm.edu/css/site.ie7.css" type="text/css" rel="stylesheet" /><![endif]-->
        <!--[if lt IE 9]>
          <script src="https://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <script src="https://media.bcm.edu/js/modernizr-2.6.2.js"></script>
    
<script language="JavaScript" type="text/JavaScript">
//THIS CODE CALCULATES THE CALORIC NEEDS OF CHILDREN BASED ON  EQUATIONS AND TABLES PUBLISHED IN 2002 NUTRITIONAL RECOMMENDATIONS OF THE FOOD AND NUTRITION BOARD OF THE NATIONAL INSTITUTES OF HEALTH: 
//EQUATION HAS BEEN MODIFIED TO ACCEPT DATA IN POUNDS AND INCHES RATHER THAN METRIC MEASURES
//THE MODIFIED BASE EQUATION IS: 
//EER=SF-(AF*Age)+PA[(WF*wt in pounds)+HF(ht inches)] + EDF  
//where SF is a factor based on Sex, 
//AF is a factor based on age; 
//PA is a sex-based factor for physical activity level; 
//WF and HF and factors for weight and height; 
//EDF is the factor for energy deposition (energy used to produce new lean or fat tissues)
 
// The main calculation function
function calcDCN (intWeight,strWeight,intHeight,strHeight,intAge,strGender,strActivity) {
//Begin Data for TEE:  SF-(AF*Age)+PA[(WF*wt in pounds)+HF(ht inches)] 

	//Assign Sex Factor (SF)
	var factorS;
	if(strGender=="male"){	factorS=662; }
	else if (strGender=="female") {	factorS = 354;	}
	//test gender factor (factorS)
	//document.dcn.Result.value=parseInt(factorS);
	// Calculate: factorA or Age Factor  (Age-dependent adjustment factor * age in years)
		var factorA;
		if(strGender=="male"){		factorA=-9.53*intAge;		}
		else if(strGender=="female") { factorA=-6.91*intAge;	} 
	//test age factor (factorA)
	//document.dcn.Result.value=parseFloat(factorA);
	
	// Assign Physical Activity  Factor (PA)
	
	//dictates that EER equation uses PA factors for normal weight boys
	var malePA;
	if(strActivity=="inactive"){ malePA=1.00; }
	else if(strActivity=="low"){ malePA=1.11; }					
	else if(strActivity=="moderate"){ malePA=1.25; }					
	else if(strActivity=="high"){ malePA=1.48;	}
						
	//dictates that EER equation uses  PA factors for normal weight girls
	var femalePA;
	if(strActivity=="inactive"){ femalePA=1.00;	}
	else if(strActivity=="low"){ femalePA=1.12;	}					
	else if(strActivity=="moderate"){ femalePA=1.27; }					
	else if(strActivity=="high"){ femalePA=1.45; }
	
	//PAfactor equation decision tree: gender--malePA or femalePA--
	var factorPA;
	if(strGender=="male"){	factorPA=malePA; }
	else if(strGender=="female"){ factorPA=femalePA; }
	//test javascript for PA factors
	//document.dcn.Result.value=parseFloat(factorPA);
			
	// Caluclate Weight Factor (WF) and Height Factor (HF)
		
	//Weight Factor
	//converts form input (pounds) into kilograms
	var convertWeight;				
	var convertPounds=0.4536;
	var convertKilograms=1;
	
	if(strWeight=="pounds"){ convertWeight =convertPounds;	}
	else if (strWeight=="kg"){	convertWeight=convertKilograms;	}

	var convertKg=intWeight * convertWeight;
	//document.dcn.Result.value=convertKg;

	var factorW;
					
	if(strGender=="male"){	factorW=15.91*convertKg; }
	else if (strGender=="female") {	factorW = 9.36*convertKg;	} 
	//test factor
	//document.dcn.Result.value=parseFloat(factorW);
		
	//Height factor
	//converts form input ( inches or cm)  into Meters

	var factorM;
	var factorInches=0.0254;
	var factorCm=0.01;

	if(strHeight=="cm"){ factorM=factorCm;	}
	else if (strHeight=="inches") {	factorM = factorInches;	} 
	
	var convertM = parseFloat(intHeight)*factorM;
	//test conversion
	//document.dcn.Result2.value=convertM;
		
	var factorH;
			
	if(strGender=="male"){	factorH=539.68*convertM; }		
	else if (strGender=="female") {	factorH=726*convertM; } 
	//test factor
	//document.dcn.Result.value=parseFloat(factorH);
		
	//Begin sub-routine -- BMI calculationsfor Results2
		
	//Height factor for BMI calculation
	var factorH2=convertM*convertM;
	//test factor
	//document.dcn.Result2.value=parseFloat(factorH2);

	//Weight factor for BMI calculation	
	var factorW2=convertKg;
	//test factor
	//document.dcn.Result2.value=parseFloat(factorW2);
	
	var factorBMI=(factorW2/factorH2)*10;
	//test factor
	document.dcn.Result2.value=parseInt(factorBMI)/10;
	
	//end BMI calculations
		
	//calculate  PA= factorPA*factorW + factorPA*factorH 
	//varible designed to test PA values inform  
	//var factorPA2=factorPA*100
	           
	var factorPAH= factorPA * factorH;
	var factorPAW = factorPA * factorW;
	var factorPAHW = factorPAH + factorPAW;
	
	//document.dcn.Result.value=parseInt(factorPAH);
	var totalEER = factorS+factorA+factorPAHW;
	// Write the result to the text box
	document.dcn.Result.value = parseInt(totalEER);
}
//end calorie calculator script
//calculate BMI Body Mass Index ( BMI ) = (Weight in Kilograms) / (Height in Meters Squared) ***
</script>
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_popupMsg(msg) { //v1.0
  alert(msg);
}
//-->
</script>
</head>
	<body data-mission="">
        <div id="fb-root"></div>
        
        <div id="corpus">
           
            <a id="top" name="top"> </a>
			
            <!-- begin content area -->
            <div id="article-content" class="row-fluid">
                <div class="row-inner">
                    <div class="span12">

                        <article id="content" data-region="content" class="region">
                            
                                <a name="pagecontent"></a>
                                 
<form name="dcn" style="border-style: solid; width: 600px;" >
	<h3>Adult BMI and Calorie Calculator</h3>
	<p>For Individuals 19 Years of Age and Older</p>
	<label><span>Sex:</span><select name="strGender">
	<option value="male" selected>Male</option>
	<option value="female">Female</option>
	</select></label>
	
	
	<label><span>Height:</span><input name="intHeight" type="text" class="text" value=""   size="3" maxlength="3"  />
	<select name="strHeight" >
	<option value="inches" selected>Inches</option>
	<option value="cm">Centimeters</option>
	</select></label>
	
	
	<label><span>Weight:</span><input name="intWeight" type="text" class="text" value="" size="3" maxlength="3"  />
	<select name="strWeight" id="select5">
	<option value="pounds" selected>Pounds</option>
	<option value="kg">kilograms (kg)</option>
	</select></label>
	
	
	<label><span>Age:</span><input name="intAge" type="text" class="text" value=""   size="2" maxlength="2"  />
	Years</label>
	
	<label><span>Are you active?</span>
		<select name="strActivity">
		<option value="inactive" selected>Rarely </option>
		<option value="low">Less than 1 hour/day</option>
		<option value="moderate">About 1 hour/day</option>
		<option value="high">More than 1 hour/day </option>
		</select>
	</label>
	<br/>
	<input type="button" class="submit" name="calculate" value="Calculate" onClick="return calcDCN(this.form.intWeight.value,this.form.strWeight.value,this.form.intHeight.value,this.form.strHeight.value,this.form.intAge.value,this.form.strGender.value,this.form.strActivity.value);">
	
	<p>Your BMI is
	<input name="Result2" type="text"  class="text" value="" size="4">
	&nbsp;and you need about&nbsp;
	<input type="text" class="text" name="Result" size="5" value="" />
	&nbsp;Calories per day to maintain your <strong>current</strong> weight<br/>
	</p>
</form>

                        </article>
                    </div>
                </div>
            </div>
            
			
        </div>
        
        <script src="https://media.bcm.edu/js/jquery-1.8.3.min.js"></script>
        <script src="https://media.bcm.edu/js/bootstrap.min.js"></script>
        <script src="https://media.bcm.edu/js/bootstrap.affix-fixed.js"></script>
        <script src="https://media.bcm.edu/js/site.fonts.js"></script>
        <script src="https://media.bcm.edu/js/jquery.ResizeManager.js"></script>
        <script src="https://media.bcm.edu/js/jquery.ResponsiveToolkit.js"></script>
        <script src="https://media.bcm.edu/js/jquery.tinyscrollbar.min.js"></script>
        <script src="https://media.bcm.edu/js/site.common.js"></script>
        <script src="https://media.bcm.edu/js/holder.js"></script>
        <script src="https://media.bcm.edu/js/storage/jquery.total-storage.min.js"></script>
        <script src="https://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
        <script src="https://media.bcm.edu/js/jquery.ajax-retry.js"></script>
        <script src="https://media.bcm.edu/js/oneweb.page.view.js"></script>
        <script src="https://media.bcm.edu/js/oneweb.core.js"></script>
        <script type="text/javascript">

            var _gaq = _gaq || [];
            _gaq.push(['_setAccount', 'UA-528843-1']);
            _gaq.push(['_trackPageview']);

            (function() {
                var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
                ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
                var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
            })();

        </script>

    </body>
</html> 
	
	
	

