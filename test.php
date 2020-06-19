<?php
  if (!empty($_GET['q'])) {
    switch ($_GET['q']) {
      case 'info':
        phpinfo();
        exit;
      break;
    }
  }
?>
<!DOCTYPE html>
<html>
    <head>
        <title>Android WebView</title>
    </head>
    <body>
        <div class="container">
            <div class="content">
                <?php
                  $userNumber = $_POST['userNumber'];
                  $length = strlen($userNumber);

                  switch($length){
                    case 11 :
                        $userNumber = preg_replace("/([0-9]{3})([0-9]{4})([0-9]{4})/", "$1-$2-$3", $userNumber);
                        break;
                    case 10:
                        $userNumber = preg_replace("/([0-9]{3})([0-9]{3})([0-9]{4})/", "$1-$2-$3", $userNumber);
                        break;
                    default :
                        return $userNumber;
                        break;
                  }
                ?>
                Tel : <?php echo $userNumber ?>
            </div>

        </div>
    </body>
</html>
