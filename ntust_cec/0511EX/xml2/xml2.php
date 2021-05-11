<?php require_once('Connections/db2.php'); ?>
<?php
if (!function_exists("GetSQLValueString")) {
function GetSQLValueString($theValue, $theType, $theDefinedValue = "", $theNotDefinedValue = "") 
{
  if (PHP_VERSION < 6) {
    $theValue = get_magic_quotes_gpc() ? stripslashes($theValue) : $theValue;
  }

  $theValue = function_exists("mysql_real_escape_string") ? mysql_real_escape_string($theValue) : mysql_escape_string($theValue);

  switch ($theType) {
    case "text":
      $theValue = ($theValue != "") ? "'" . $theValue . "'" : "NULL";
      break;    
    case "long":
    case "int":
      $theValue = ($theValue != "") ? intval($theValue) : "NULL";
      break;
    case "double":
      $theValue = ($theValue != "") ? doubleval($theValue) : "NULL";
      break;
    case "date":
      $theValue = ($theValue != "") ? "'" . $theValue . "'" : "NULL";
      break;
    case "defined":
      $theValue = ($theValue != "") ? $theDefinedValue : $theNotDefinedValue;
      break;
  }
  return $theValue;
}
}

mysql_select_db($database_db2, $db2);
$query_Recordset1 = "SELECT * FROM table1";
$Recordset1 = mysql_query($query_Recordset1, $db2) or die(mysql_error());
$row_Recordset1 = mysql_fetch_assoc($Recordset1);
$totalRows_Recordset1 = mysql_num_rows($Recordset1);
?>
<?php echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
echo "<留言板>\n"; ?>
<?php do { ?>
<?php //以下是XML格式
echo "<留言>\n";
echo "<編號>".$row_Recordset1['no1']."</編號>\n";
echo "<姓名>".$row_Recordset1['name1']."</姓名>\n";		
echo "<留言>".$row_Recordset1['content1']."</留言>\n";		
echo "<時間>".$row_Recordset1['time1']."</時間>\n";		
echo "</留言>\n";
?>
<?php } while ($row_Recordset1 = mysql_fetch_assoc($Recordset1)); ?>
<?php echo "</留言板>\n";?>
<?php
mysql_free_result($Recordset1);
?>
