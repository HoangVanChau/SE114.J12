<?php
    
    defined('BASEPATH') OR exit('No direct script access allowed');
    
    class admin_model extends CI_Model {
        public function getAllData($table){
            $this->db->select('*');
            $result = $this->db->get($table);
            return $result->result_array();
        }
        public function getDataById($id, $table){
            $this->db->select('*');
            $this->db->where('id', $id);
            $result =$this->db->get($table);
            return $result->result_array();
        }
        public function deleteDataById($id, $table){
            $this->db->where('id', $id);
            $this->db->delete($table);
        }
        public function updateData($table,$data, $id){
            $this->db->where('id', $id);
            
            $this->db->update($table, $data);
        }
        public function insertData($table, $data){
            $this->db->insert($table, $data);
            return $this->db->insert_id();
        }
        public function getOrderDetail($id){
            $this->db->select('*');
            $this->db->where('madonhang', $id);
            $result =$this->db->get("chitietdonmuahang");
            return $result->result_array();
        }
    }
    
    /* End of file admin_model.php */
    