<?php 
    
    defined('BASEPATH') OR exit('No direct script access allowed');
    
    class Admin extends CI_Controller {

        
        public function __construct()
        {
            parent::__construct();
            $this->load->model('admin_model');
        }
        
        
        public function index()
        {
            $pd = $this->admin_model->getAllData('sanpham');
            $data = array('pd' => $pd );
            $this->load->view('products_view', $data, false);
        }
            // uploads
        public function uploads($image){
            $target_dir = "uploads/";
            $target_file = $target_dir . basename($_FILES[$image]["name"]);
            $uploadOk = 1;
            $imageFileType = strtolower(pathinfo($target_file,PATHINFO_EXTENSION));
            // Check if image file is a actual image or fake image
            if(isset($_POST["submit"])) {
                $check = getimagesize($_FILES[$image]["tmp_name"]);
                if($check !== false) {
                    // echo "File is an image - " . $check["mime"] . ".";
                    $uploadOk = 1;
                } else {
                    // echo "File is not an image.";
                    $uploadOk = 0;
                }
            }
            // Check if file already exists
            if (file_exists($target_file)) {
                // echo "Sorry, file already exists.";
                $uploadOk = 0;
            }
            // Check file size
            if ($_FILES[$image]["size"] > 500000) {
                // echo "Sorry, your file is too large.";
                $uploadOk = 0;
            }
            // Allow certain file formats
            if($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg"
            && $imageFileType != "gif" ) {
                // echo "Sorry, only JPG, JPEG, PNG & GIF files are allowed.";
                $uploadOk = 0;
            }
            // Check if $uploadOk is set to 0 by an error
            if ($uploadOk == 0) {
                // echo "Sorry, your file was not uploaded.";
            // if everything is ok, try to upload file
            } else {
                if (move_uploaded_file($_FILES[$image]["tmp_name"], $target_file)) {
                    // echo "The file ". basename( $_FILES[$image]["name"]). " has been uploaded.";
                } else {
                    // echo "Sorry, there was an error uploading your file.";
                }
            }     
            return $imagename = base_url()  ."uploads/" .basename($_FILES[$image]["name"]);
        }
        //user
        //products
        public function products()
        {
            $pd = $this->admin_model->getAllData('sanpham');
            $data = array('pd' => $pd );
            $this->load->view('products_view', $data, false);
        }
        public function users(){
            $users = $this->admin_model->getAllData('khachhang');
            $data = array(
                'users' => $users
             );
            $this->load->view('users_view', $data, FALSE);
        }
        //order
        public function orders(){
            $orders = $this->admin_model->getAllData('donhang');
            $data = array(
                'orders' => $orders
             );
            $this->load->view('orders_view', $data, FALSE);
        }
        //orderdetail
        public function orderdetail($id){
            $result = $this->admin_model->getOrderDetail($id);
            $data = array(
                'order' => $result
             );
            $this->load->view('orderdetail_view', $data, FALSE);
        }
        //edit products
        public function editProduct($id){
            $pd = $this->admin_model->getDataById($id, "sanpham");
            $loaisp = $this->admin_model->getAllData("loaisanpham");
            $data = array(
                'pd' => $pd ,
                'loaisp' => $loaisp ,
             );
            $this->load->view('product_edit_view', $data, FALSE);
        }
        public function deleteProduct($id){
            $this->admin_model->deleteDataById($id, "sanpham");
            redirect('admin','refresh');
        }
        public function addProduct(){
            $loaisp = $this->admin_model->getAllData("loaisanpham");
            $data = array(
                'loaisp' => $loaisp 
             );
            $this->load->view('products_add_view.php', $data, FALSE);  
        }
        public function saveProduct(){
            $id = $this->input->post('id');
            $name = $this->input->post('name');
            $price = $this->input->post('price');
            $desc = $this->input->post('desc');
            $list = $this->input->post('listpd');
            $this->uploads('new_image');   
            if( empty($_FILES["new_image"]["name"])){
                $image = $this->input->post('old_image');
            }
            else {
                $image = $this->uploads('new_image');
            }
            $data = array(
                'id' => $id ,
                'tenSanPham' => $name ,
                'moTaSanPham' => $desc ,
                'giaSanPham' => $price ,
                'idLoaiSanPham' => $list,
                'hinhAnhSanPham' => $image
            );
            $this->admin_model->updateData("sanpham", $data, $id);
            redirect('admin','refresh');
        }
        public function insertPd(){
            $id = $this->input->post('id');
            $name = $this->input->post('name');
            $price = $this->input->post('price');
            $desc = $this->input->post('desc');
            $list = $this->input->post('listpd');
            $image = $this->uploads('new_image');   
            $data = array(
                'id' => $id ,
                'tenSanPham' => $name ,
                'moTaSanPham' => $desc ,
                'giaSanPham' => $price ,
                'idLoaiSanPham' => $list,
                'hinhAnhSanPham' => $image
            );
            $this->admin_model->insertData("sanpham", $data);
            redirect('admin','refresh');
        }
    }
    
    /* End of file Admin.php */
    