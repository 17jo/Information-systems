<?php
 if (isset($_GET['ckid'])) {
 $outcome=rand(0,100);
 if($outcome>50)
	echo "odbijeno";
 else
	echo "prihvaceno";
 }else{
	echo "Pasos id not set";	
 }
?>