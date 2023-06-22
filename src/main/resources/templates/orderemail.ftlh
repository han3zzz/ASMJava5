
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
	<div style="text-align: center;"><img style="width: 170px ; height: 100px" src="https://img.upanh.tv/2023/03/29/logo.png"/></div>
	<div>
	<p style="text-align: center; font-family: Montserrat, sans-serif; font-size: 20px ; font-weight: bold;">Cảm ơn bạn đã đặt hàng !</p>
	<p style="text-align: center; font-family: Montserrat, sans-serif; font-size: 15px">Xin chào ${hd.nguoiNhan}, cảm ơn bạn đã tin tưởng và đặt hàng tại HanLuxury <br>
	Chúng tôi sẽ giao hàng tới bạn trong thời gian sớm nhất !
	</p>
	
	</div>
	<hr>
	<div>
	<p style="text-align: center; font-family: Montserrat, sans-serif; font-size: 15px ; font-weight: bold;">Thông tin giao hàng</p>
	<p style="text-align: center; font-family: Montserrat, sans-serif; font-size: 15px">${hd.nguoiNhan}
	<br>${hd.soDienThoai}
	<br>${hd.diaChi}
	 </p>
	</div>
	<hr>
	<div>
	<p style="text-align: center; font-family: Montserrat, sans-serif; font-size: 15px ; font-weight: bold;">Chi tiết đơn hàng #${hd.idHoaDon}</p>
	<table style="margin-left: 300px ;text-align: center; border-collapse: collapse;font-family: Montserrat, sans-serif; font-size: 15px ;" >
	<tr >
	<td style="padding-right: 30px ;font-weight: bold;">Tên sản phẩm</td>
	<td style="padding-right: 30px;font-weight: bold;">Kích cỡ</td>
	<td style="padding-right: 30px;font-weight: bold;">Số lượng</td>
	<td style="padding-right: 30px;font-weight: bold;">Đơn giá</td>
	<td style="padding-right: 30px;font-weight: bold;">Thành tiền</td>
	</tr>
	<#assign x = 0>  <#-- create variable x -->
	<#list hdct as h>
 <tr >
	<td style="padding-right: 30px">${h.product.tieuDe}</td>
	<td style="padding-right: 30px">${h.kichThuoc}</td>
	<td style="padding-right: 30px">${h.soLuong}</td>
	<td style="padding-right: 30px">${h.donGia}</td>
	<td style="padding-right: 30px">${h.soLuong * h.donGia}</td>
	<#assign x += h.soLuong * h.donGia>  <#-- create variable x -->
	</tr>
</#list>
	</table>
	<hr>
	<p  style="padding-left: 600px; font-family: Montserrat, sans-serif; font-size: 15px; font-weight: bold;">Tổng tiền : ${x} VNĐ</p>
	</div>
	<hr>
	<div>
	<p style="text-align: center; font-family: Montserrat, sans-serif; font-size: 15px">Nếu bạn có bất kì câu hỏi nào, vui lòng liên hệ với chúng tôi <br> qua email <strong>hanhnph24141@fpt.edu.vn</strong> <br>48 Ngõ 99 Cầu Diễn, Từ Liêm, Hà Nội.</p>
	</div>
	<div><img style="width: 1110px" src="https://img.upanh.tv/2023/03/30/hanfooter.png"></div>
	</div>
</body>
</html>