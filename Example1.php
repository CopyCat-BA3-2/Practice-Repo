<!DOCTYPE html>
<html>
      <head>
             <meta charset="UTF-8">
             <meta name="Viewport"  content="width=device-width, initial-scale=1.0">

             <title>Login form</title>
      </head>


      <body>
            <header style="text-align:center" ><b>Login</b></header>


            <main>
                  <?php

                   //Declare php Variables
                    $first_name = "Mcacisi";
                    $last_name = "Sithole";
                    $string1 = "My name is";
                    $string2 = "I am";
                    $string3 = "years old";
                    
                    $age= 22;
                    $integer1 = 4;
                    
                    $float1 = 2.97;
                    $float2 = 1.23;
                    
                    $boolean1 = true;

                    $array1 = array("Monday","Tuesday","Wednesday");
                    $array2 = array(1,2,3);

                    //DISPLAY PHP VARIABES
                    echo "1st Student: $string1 $first_name $last_name ";
                    echo "<br>";
                    echo "$string2 $age $string3 ";
                    echo "<br>";
                    echo "float division: ".round($float1/$float2) ;
                    echo "<br>";
                    echo "Age division:" .round($age/$integer1);
                    echo "<br>";
                    echo "Boolean:" .$boolean1;
                      
                  ?>

            </main>

            <footer></footer>
      <!-- Code injected by live-server -->
<script>
	// <![CDATA[  <-- For SVG support
	if ('WebSocket' in window) {
		(function () {
			function refreshCSS() {
				var sheets = [].slice.call(document.getElementsByTagName("link"));
				var head = document.getElementsByTagName("head")[0];
				for (var i = 0; i < sheets.length; ++i) {
					var elem = sheets[i];
					var parent = elem.parentElement || head;
					parent.removeChild(elem);
					var rel = elem.rel;
					if (elem.href && typeof rel != "string" || rel.length == 0 || rel.toLowerCase() == "stylesheet") {
						var url = elem.href.replace(/(&|\?)_cacheOverride=\d+/, '');
						elem.href = url + (url.indexOf('?') >= 0 ? '&' : '?') + '_cacheOverride=' + (new Date().valueOf());
					}
					parent.appendChild(elem);
				}
			}
			var protocol = window.location.protocol === 'http:' ? 'ws://' : 'wss://';
			var address = protocol + window.location.host + window.location.pathname + '/ws';
			var socket = new WebSocket(address);
			socket.onmessage = function (msg) {
				if (msg.data == 'reload') window.location.reload();
				else if (msg.data == 'refreshcss') refreshCSS();
			};
			if (sessionStorage && !sessionStorage.getItem('IsThisFirstTime_Log_From_LiveServer')) {
				console.log('Live reload enabled.');
				sessionStorage.setItem('IsThisFirstTime_Log_From_LiveServer', true);
			}
		})();
	}
	else {
		console.error('Upgrade your browser. This Browser is NOT supported WebSocket for Live-Reloading.');
	}
	// ]]>
</script>
</body>

</html>