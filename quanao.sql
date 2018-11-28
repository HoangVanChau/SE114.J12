-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2018 at 07:40 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanao`
--

-- --------------------------------------------------------

--
-- Table structure for table `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `id` int(11) NOT NULL,
  `tenLoaiSanPham` varchar(200) NOT NULL,
  `hinhAnhLoaiSanPham` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `loaisanpham`
--

INSERT INTO `loaisanpham` (`id`, `tenLoaiSanPham`, `hinhAnhLoaiSanPham`) VALUES
(1, 'Giày', 'https://i2.wp.com/hnbmg.com/wp-content/uploads/2016/03/Rick-Owens-By-Drkshdw-shoes-FW-14-Moody-Sneakers-Mens-Black-010606.jpg?resize=480%2C360'),
(2, 'Nón ', 'https://product.hstatic.net/1000230642/product/dsc_0305_805166acb1664f42b529cf1a4e8b232b_1024x1024.jpg'),
(3, 'Áo ', 'https://vn-test-11.slatic.net/p/7/ao-thun-nam-tron-co-gian-co-tron-new-fashion-xanh-den-8818-2623629-9bb08843728d6696d0016bae70dafe46-catalog.jpg_340x340q80.jpg_.webp'),
(4, 'Quần', 'https://4menshop.com/images/thumbs/2015/09/quan-tay-cong-so-den-qt20-4885-slide-1.jpg'),
(5, 'Dép ', 'https://photo-3-baomoi.zadn.vn/w1000_r1/18/03/01/105/25103888/1_86074.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `tenSanPham` varchar(200) NOT NULL,
  `giaSanPham` int(15) NOT NULL,
  `hinhAnhSanPham` varchar(200) NOT NULL,
  `moTaSanPham` varchar(1000) NOT NULL,
  `idLoaiSanPham` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`id`, `tenSanPham`, `giaSanPham`, `hinhAnhSanPham`, `moTaSanPham`, `idLoaiSanPham`) VALUES
(1, 'Giày thể thao nam sneaker màu trắng', 80000, 'https://vn-test-11.slatic.net/shop/b25043883b2b57917aa3c43002b106be.jpeg', 'Mã sản phẩm : CDT\r\nThiết kế thời trang- Màu sắc: Trắng- Dễ phối đồ\r\nChất liệu cao cấp, khử mùi, thoáng khí\r\nĐường may tinh tế- Êm và ôm chân\r\nSản phẩm được đảm bảo chất lượng\r\nKiểu dáng phong cách, trẻ trung, ấn tượng\r\nĐế cao su non đúc, tạo cảm giác thoái mái khi đi.\r\nSize: 38, 39, 40, 41, 42, 43', 1),
(2, 'Giày Sneaker Nam Năng Động Màu Xám - Pettino P003', 170000, 'https://vn-live-01.slatic.net/original/77897ea9fe3b077de3e2de03f59a83d5.jpg', 'Thiết kế trẻ trung\r\nDễ dàng phối trang phục\r\nĐồng kiểm: xem hàng khi nhận hàng\r\nCOD Thanh toán khi nhận hàng\r\nGiao hàng nhanh\r\nGiao hàng tiết kiệm\r\nChất liệu cao cấp\r\nMũi giày tròn\r\nĐế bằng cao su tổng hợp; xẻ rãnh chống trơn trượt', 1),
(3, 'Giày Nam - Giày Nam - Giày Nam - Giày Nam - T0101', 229000, 'https://media3.scdn.vn/img2/2017/12_25/E3otSP_simg_de2fe0_500x500_maxb.png', 'Giày có 2 màu vàng và đen đỏ.\r\nFull size từ 39 đến 43.\r\nĐế giày là cao su non đúc nguyên khối, thân giày là lớp vải xốp kết hợp da PU.\r\nGiày có form chuẩn nên bình thường các bạn đi size nào thì cứ chọn size đấy thôi.', 1),
(4, 'Giày nam trắng thể thao sneaker- khuyến mãi 50% chào mừng Quốc Khánh', 103000, 'https://vn-test-11.slatic.net/shop/5b53d7e299a046aa7e856ecd2c2af151.jpeg', 'Mã sản phẩm : GST09\r\nThiết kế thời trang- độn đế bí mật cao 6 cm\r\nMàu sắc: Trắng- Dễ phối đồ\r\nChất liệu cao cấp, khử mùi, thoáng khí\r\nĐường may tinh tế- Êm và ôm chân\r\nSản phẩm được đảm bảo chất lượng\r\nKiểu dáng phong cách, trẻ trung, ấn tượng\r\nĐế cao su non đúc, tạo cảm giác thoái mái khi đi.\r\nSize: 38, 39, 40, 41, 42, 43', 1),
(5, 'Giày thể thao nam Muidoi G145 (Đen)', 90000, 'https://vn-test-11.slatic.net/shop/d0107ab7c579146eae6ecc94391dbfc3.jpeg', 'Mạnh mẽ nam tính cùng Giày thể thao nam đế trắng sạch sẽ không bám bẩn,Phần đế chất liệu cao su cao cấp mềm mại, siêu nhẹ không đau chân khi vận động mạnh,thân giày là sự kết hợp giữa vải lưới và logo hãng thoáng khí chống hôi chân hay hầm bí khi mang.Từng đường may được trau chuốt kỹ lưỡng nhằm tạo nên một đôi giày hoàn hảoForm giày mới, phù hợp với hầu hết kiểu chân.Đế và thân được dán chắc bằng máy áp keo đảm bảo độ bền trên 1 năm.', 1),
(6, 'Nón lưỡi trai nam thời trang 2018', 30000, 'https://vn-test-11.slatic.net/shop/bf609f1db1ecc017ff1993e426351d62.jpeg', 'Mũ lưỡi trai trơn các màu.\r\nChất liệu kaki.\r\nKiểu dáng trẻ đẹp.\r\nHàng có sẵn\r\nNónbền đẹp, không tạo cảm giác hầm, bức bí khi đội nón.\r\nNón được thiết kế đẹp mắt, thời trang với những đường may tỉ mỉ sẽ giúp bạn tự tin hơn trong những ngày nắng\r\nPhía sau có phần điều chỉnh kích thước phù hợp với từng kích cỡ của mỗi người, rất tiện lợi khi sử dụng.\r\nNón nam nữ thể thaocó thiết kế nón lưỡi trai cổ điển nhưng cá tính, vành nón trẻ trung và phong cách, giúp bạn luôn nổi bật khi xuống phố\r\nCó thể kết hợp cùng những item như áo thun, quần jeans, quần short năng động hay những item nữ tính, trẻ trung để luôn tự tin trong nhiều hoàn cảnh', 2),
(7, 'Nón Bucket Chữ Nhật Cá Tính - Mũ Tai Bèo Vải Tốt', 50000, 'https://vn-test-11.slatic.net/shop/d715e51651dae66b98bbaa02c17acd80.jpeg', 'Mẫu mũ tai bèo Bucket siêu Hot hè 2018 siêu ngộ nghĩnh với phần vành mềm và không quá rộng, loại mũ tai bèo đã thịnh hành từ những năm 90 còn gọi là “bucket hat” trong tiếng Anh. Hàng chục năm trôi qua chiếc mũ tai bèo có chăng chỉ là phong phú hơn về chất liệu cũng như màu sắc, họa tiết trên mũ.', 2),
(8, 'Nón - Nón kết', 150000, 'https://media3.scdn.vn/img2/2018/5_10/HXHjKN_simg_de2fe0_500x500_maxb.jpg', 'Chất liệu KAKI bền đẹp. Thiết kế form nón ôm vừa vặn, bố cục họa tiết độc đáo sáng tạo, mang lại vẻ cá tính cho bạn trẻ. ĐIỂM NỔI BẬT Nón lưỡi trai nam nữ thiết kế logo được thêu nổi ở chính giữa nón cùng với họa tiết ở bên phải nón thật thời trang và phong cách Thiết kế theo kiểu lưỡi trai cổ điển, phần lưỡi trai cong tạo nên nét mạnh mẽ và thời trang cho sản phẩm Sau nón có nút điều chỉnh cho vừa với khuôn đầu mỗi người với form nón ôm, vừa vặn và đẹp mắt. Với chất liệu kaki bền đẹp, cho form nón đứng với đường may chắc chắn, đồng thời tạo độ thông thoáng cho người dùng Những ngày hè nắng nóng, khi ra ngoài, ai cũng phải trang bị cho mình những sản phẩm có khả năng chống nắng tốt. Từ áo khoác, khẩu trang tới găng tay, tất vớ...và chắc rằng, chúng ta không thể bỏ qua những chiếc nón. Hiện diện trong cuộc sống của chúng ta từ rất lâu đời, đến nay, hầu như ai cũng có cho mình một chiếc nón để diện ngày nắng. Bạn chọn nón parama sang trọng hay mũ lưỡi trai trẻ trung, bình dân? Cùng xem m', 2),
(9, 'NÓN KẾT NÓN KẾT - SNAPBACK DA TRƠN', 82000, 'https://media3.scdn.vn/img2/2018/5_29/HdLqA8_simg_de2fe0_500x500_maxb.jpg', '[XẢ HÀNG] NÓN SNAPBACK DA TRƠN [GIÁ SỐC]\r\nNÓN KẾT\r\n\r\nNón snapback nam nữ Mister RGM: Chất liệu da PU bền đẹp tạo dáng nón cứng cáp, chắc chắn. Thiết kế đơn giản với kiểu dáng thời trang, sành điệu, mang đến phong cách trẻ trung, năng động ĐIỂM NỔI BẬT Nón snapback nam nữ được thiết kế đơn giản với kiểu dáng thời trang, sành điệu, mang đến phong cách trẻ trung, năng động Mặt trước nón in chữ hoa trên nền , nổi bật mà tinh tế, đẹp mắt, cho bạn thêm cá tính, phong cách Phía sau có nút bấm nhựa, giúp bạn thoải mái điều chỉnh độ rộng phù hợp với vòng đầu của mình Màu trắng đơn giản, trẻ trung, không lỗi mốt, rất dễ phối đồ, phù hợp với nam và nữ Chất liệu bền đẹp tạo dáng nón cứng cáp, chắc chắn mang tới cho bạn sự thích thú, an tâm khi sử dụng Nếu bạn là một người theo đuổi các xu hướng thì không có lí do gì để có thể bỏ qua chiếc nón snapback - một trong những item tiêu biểu đại diện cho phong cách swag trẻ trung, khỏe khoắn đang cực \"hot\" đối với giới trẻ hiện nay. Cho tới nay, nón snapb', 2),
(10, 'NÓN KẾT NÓN KẾT - NÓN JEAN 2', 75000, 'https://media3.scdn.vn/img2/2018/9_1/99Vscz_simg_de2fe0_500x500_maxb.jpg', 'Chất liệu KAKI bền đẹp. Thiết kế form nón ôm vừa vặn, bố cục họa tiết độc đáo sáng tạo, mang lại vẻ cá tính cho bạn trẻ. ĐIỂM NỔI BẬT Nón lưỡi trai nam nữ thiết kế logo được thêu nổi ở chính giữa nón cùng với họa tiết ở bên phải nón thật thời trang và phong cách Thiết kế theo kiểu lưỡi trai cổ điển, phần lưỡi trai cong tạo nên nét mạnh mẽ và thời trang cho sản phẩm Sau nón có nút điều chỉnh cho vừa với khuôn đầu mỗi người với form nón ôm, vừa vặn và đẹp mắt. Với chất liệu kaki bền đẹp, cho form nón đứng với đường may chắc chắn, đồng thời tạo độ thông thoáng cho người dùng Những ngày hè nắng nóng, khi ra ngoài, ai cũng phải trang bị cho mình những sản phẩm có khả năng chống nắng tốt. Từ áo khoác, khẩu trang tới găng tay, tất vớ...và chắc rằng, chúng ta không thể bỏ qua những chiếc nón. Hiện diện trong cuộc sống của chúng ta từ rất lâu đời, đến nay, hầu như ai cũng có cho mình một chiếc nón để diện ngày nắng. Bạn chọn nón parama sang trọng hay mũ lưỡi trai trẻ trung, bình dân? Cùng xem m', 2),
(11, 'Áo nữ ', 199000, 'https://media3.scdn.vn/img2/2018/9_11/roPxZq_simg_de2fe0_500x500_maxb.jpg', 'Sét bộ váy len hàng Quảng Châu xịn với Phong cách nước Anh hot hit của năm với màu sắc nhã nhặn, nhiều lựa chọn, phom dáng xinh đẹp, kiểu dáng thích hợp cho bạn gái  luôn nổi bật, thích hợp đến văn phòng, dạo phố, đi chơi, đi học…', 3),
(12, 'Áo nữ xanh', 110000, 'https://media3.scdn.vn/img2/2018/10_9/Wvzt1D_simg_de2fe0_500x500_maxb.jpg', 'Áo Quảng Châu có thiết kế trẻ trung, hiện đại, với form tôn dáng, thoải mái\r\nDễ mix kèm trang phục cho bạn gái nét ngoài năng động, khỏe khoắn.\r\nChất liệu: len mỏng thoáng mát, co giãn.\r\nXuất xứ: Quảng Châu.\r\nKích thước: (cm)', 3),
(13, 'Quần Jogger', 95000, 'https://media3.scdn.vn/img2/2018/6_26/hv0z12_simg_de2fe0_500x500_maxb.jpg', 'Free size: 65kg trở xuống mặc vừa\r\n\r\nQuần chất nỉ 100% siêu mịn đẹp.\r\nForm chuẩn, mặc thoải mái, co giãn tốt.\r\nChất liệu cao cấp, mát, thấm hút mồ hôi tốt.\r\nHàng cam kết như hình, ảnh chụp thật sản phẩm.\r\nHàng cam kết giá tốt.\r\nVới chất liệu tốt sẽ đem đến cho quý khách sự hài lòng.\r\nChất liệu: Vải Nỉ bông, co dãn, thấm hút mồ hôi tốt, không nóng bức khi vận động nhiều, không nhăn, không co rút sau khi giặt.\r\n\r\nChất liệu mềm sang trọng, tạo sự nổi bật, quyến rũ cho người mặc\r\n', 4),
(14, 'Quần Jogger - DT65LL552', 99000, 'https://media3.scdn.vn/img2/2018/4_14/C5tEvV_simg_de2fe0_500x500_maxb.jpg', 'Chất liệu: Kaki dày dặn (co giãn tốt), cách điệu, thiết kế trẻ trung hiện đại mang đến cho bạn phong cách năng động nhưng không kém phần nam tính, lịch lãm.\r\n\r\nChất liệu kaki, mượt, thông thoáng, thấm hút mồ hôi tốt, co giãn nhẹ , tạo cảm giác thoải mái cho người mặc.\r\n\r\nKiểu dáng Form body tôn dáng của bạn.\r\n\r\nMàu sắc: đen - xám-xanh-kem\r\n\r\nVới chiếc quần cực chất thế này bạn có thể dùng làm trang phục cho các buổi dự tiệc, dạo phố, công sở,.. và cực dễ phối đồ với các trang phục khác.\r\n\r\n*Sản phẩm may phù hợp với nhiều vóc dáng , phù hợp cho các bạn có chiều cao dưới 1m70 và cân nặng dưới 70kg\r\n\r\nKích thước - hướng dẫn chọn size :\r\n\r\nSize M : dưới 55KG (tùy chiều cao)\r\n\r\nSize L : dưới 65KG (tùy chiều cao)\r\n\r\nSize XL : dưới 75KG (tùy chiều cao)\r\n\r\n(size sản phẩm còn tuỳ thuộc vào chiều cao và thân hình mỗi người)', 4),
(15, 'Dép - SPU-X4', 135000, 'https://media3.scdn.vn/img2/2018/7_28/IN5Yt9_simg_de2fe0_500x500_maxb.jpg', 'QUAI: là lớp da PU cao cấp mang vừa mềm và êm chân\r\nĐẾ : cao su thiên nhiên 100%, cao su có tính năng ma sát cao chống trơn trượt an toàn cho người sử dụng\r\nChiều cao: gót 1.5cm, mũi 1cm\r\nNặng từ 600gram đến 750 gram tùy thuộc size dép\r\nVới thiết kế Dép nam vừa đơn giản vừa hiện đại , phù hợp trong các hoạt động: đi chơi, đi làm, đi học,...\r\nViệc lựa chọn cho mình một đôi dép vừa thích hợp đi chơi, du lịch, dạo phố, hay gặp gỡ bạn bè vừa mang đến phong cách trẻ trung, năng động là điều mà phái mạnh luôn quan tâm, Với đôi dép quai bố đầy cá tính phối cùng những chiếc quần jean rách bụi bặm, cho đến những chiếc quần short sắc màu trẻ trung đem đến cho người mặc những phong cách thời trang riêng.', 5),
(16, 'Dép đi trong nhà ', 57000, 'https://media3.scdn.vn/img2/2018/11_22/fSpR5v_simg_de2fe0_500x500_maxb.jpg', ' - Tên sản phẩm: Dép bông đi trong nhà cao cấp\r\n- Chất liệu: lông nhân tạo khi mang vào tạo cho người mang cảm giác mềm mại, êm ái với da\r\n\r\n- Dép bông đi trong nhà sử dụng vải bông cao cấp được thiết kế với 3 lớp: vải lông, lớp xốp đàn hồi và nhựa dẻo tổng hợp.\r\n\r\n- Đế gai cao su, bám nền gạch, chống trơn trượt, may bằng chỉ nylon, chắc chắn khi tiếp xúc với nước.\r\n\r\nMàu sắc : nhiều màu shop gửi ngẫu nhiên. Quý khách có thể lưu ý màu sắc.', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
