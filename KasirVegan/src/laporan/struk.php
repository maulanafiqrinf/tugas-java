<?php
	include "database/koneksi.php";
	$struk = $_GET['id'];
?>
<!DOCTYPE html>
<html>
<head>
	<title>Laporan</title>
</head>
<body>
	<form method="post">
	<table border="1" align="center">
		<tr>
			<td>
				<div class="mainutama" style="width: 500px;">
					<table align="center"> 
						<tr>
							<td width="7%" rowspan="3" align="center" valign="top"></td>
       						<td width="93%" valign="bottom">&nbsp;Struk  Milsaf store</td>
						</tr>
						<tr>
							<td colspan="2">JlBasuki Rahmat</td>
						</tr>
					</table>
					<hr>
					Kode Transaksi :<?php echo $struk ?><p>Tgl :<?php echo date('y-m-d H:i:s') ?></p>
					<hr>
					<table width="100%">
						<tr>
							<td>No</td>
							<td>Item</td>
							<td>Harga</td>
							<td>Jumlah</td>
							<td>Subtotal</td>
						</tr>
						<?php 
						$total = 0;
						$kembali = 0;
						$bayar =0 ;
						$no = 0;
						$sql = "select pemesanan.*, menu.nama_menu,menu.harga from pemesanan inner join menu on pemesanan.kd_menu = menu.kd_menu";
						$qury = mysqli_query($con,$sql);
						
						while ($data = mysqli_fetch_array($qury)) {

							$total = $total + $data['sub_total'];
							$no++;
							?>
							<tr>
								<td><?php echo $no ?></td>
								<td><?php echo $data['nama_menu'] ?></td>
								<td><?php echo $data['harga'] ?></td>
								<td><?php echo $data['qty'] ?></td>
								<td><?php echo $data['sub_total'] ?></td>
							</tr>
							
							<?php
						}

						 ?>
						 <tr>
						 	<td colspan="3"></td>
						 	<td>Total</td>
						 	<td><u><?php echo $total ?></u></td>

						 </tr>
					</table>
					<hr>
			    	<table align="center">
			      		<tr>
			        	<td>&copy; <?php echo date('Y'); ?> Milsaf Store</td>
			      		</tr>
			    	</table>
				</div>
			</td>
		</tr>
	</table>
	</form>

</body>
</html>