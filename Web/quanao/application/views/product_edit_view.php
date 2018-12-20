<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Edit Products</title>
		<!-- Bootstrap Core Css -->
	<link href="<?= base_url() ?>assets/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">
	<link href="<?= base_url() ?>assets/css/useredit.css" rel="stylesheet" />
	<link href="<?= base_url() ?>assets/css/bootstrap-imageupload.css" rel="stylesheet">
</head>

<body>
	<!-- Edit Modal HTML -->
	<div id="editEmployeeModal" class="" style="margin:auto; width:900px">
		<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="card">
					<div class="container-fluid">
						<form action="<?= base_url()?>admin/saveProduct/<?= $pd[0]['id']?>" id="editpartner" method="POST" enctype="multipart/form-data">
							<hr>
							<div class="row">
								<div class="col-md-4"><img src="<?= $pd[0]['hinhAnhSanPham']?>" id="image" class="img-responsive"></div>
								<input type="hidden" id="old_image" name="old_image" value="<?= $pd[0]['hinhAnhSanPham']?>">
								<input type="hidden" id="id" name="id" value="<?= $pd[0]['id']?>">
								<div class="col-md-8">
									<br>
									<!-- body -->
									<div class="body">
										<label for="">Tên sản phẩm</label>
										<div class="form-group">
											<div class="form-line">
												<input type="text" id="name" name="name" class="form-control" value="<?= $pd[0]['tenSanPham']?>" required>
											</div>
										</div>

										<label for="">Giá</label>
										<div class="form-group">
											<div class="form-line">
												<input type="number" id="price" min="0.00" step="1000.00" name="price" class="form-control" value="<?= $pd[0]['giaSanPham']?>"
												 required>
											</div>
										</div>

										<label for="">Mô tả</label>
										<div class="form-group">
											<div class="form-line">
												<input type="text" id="desc" name="desc" class="form-control" value="<?= $pd[0]['moTaSanPham']?>" required>
											</div>
										</div>

										<div class="form-group">
											<div class="body">
												<div class="row clearfix">
													<div class="col-md-3">
														<p>
															<b>Danh mục</b>
														</p>
														<select class="form-control show-tick" name="listpd" data-live-search="true">
															<?php foreach ($loaisp as $key => $value): ?>
															<option value="<?= $value['id'] ?>" selected="<?php if( $value['id'] == $pd[0]['idLoaiSanPham']){echo 'selected';}?>">
																<?= $value['tenLoaiSanPham'] ?>
															</option>
															<?php endforeach ?>
														</select>
													</div>
												</div>
											</div>
										</div>
										<label for="">Ảnh</label>
										<div class="form-group">
											<div class="body">
												<div class="row clearfix">
													<!-- bootstrap-imageupload. -->
													<div class="imageupload panel panel-default">
														<div class="panel-heading clearfix">
															<h3 class="panel-title pull-left">Upload Image</h3>
															<div class="btn-group pull-right">
																<button type="button" class="btn btn-default active">File</button>
																<button type="button" class="btn btn-default">URL</button>
															</div>
														</div>
														<div class="file-tab panel-body">
															<label class="btn btn-default btn-file">
																<span>Browse</span>
																<!-- The file is stored here. -->
																<input type="file" name="new_image">
															</label>
															<button type="button" class="btn btn-default">Remove</button>
														</div>
														<div class="url-tab panel-body">
															<div class="input-group">
																<input type="text" class="form-control hasclear" placeholder="Image URL">
																<div class="input-group-btn">
																	<button type="button" class="btn btn-default">Submit</button>
																</div>
															</div>
															<button type="button" class="btn btn-default">Remove</button>
															<!-- The URL is stored here. -->
															<input type="hidden" name="image-url">
														</div>
													</div>
												</div>

											</div>
											<!-- end -->
										</div>
										<br>
									</div>
									<!-- end body -->
								</div>
							</div>
							<hr>
							<br>
							<div class="modal-footer" style="background: #ecf0f1; border-radius: 0 0 3px 3px;">
								<input type="button" class="btn btn-default" data-dismiss="modal" value="Huỷ" onclick="pageRedirect()">
								<input type="submit" class="btn btn-primary waves-effect" value="Lưu">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
	<!-- Jquery Core Js -->
	<script src="<?= base_url() ?>assets/plugins/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core Js -->
	<script src="<?= base_url() ?>assets/plugins/bootstrap/js/bootstrap.js"></script>

	<!-- Select Plugin Js -->
	<script src="<?= base_url() ?>assets/plugins/bootstrap-select/js/bootstrap-select.js"></script>
	<!-- dđ -->
	<script src="<?= base_url() ?>assets/js/bootstrap-imageupload.js"></script>

	<script>
		var $imageupload = $('.imageupload');
		$imageupload.imageupload();
	</script>
	<script type="text/javascript">
    function pageRedirect() {
      window.location.href = "<?= base_url()?>admin";
    }      
</script> 
</html>
