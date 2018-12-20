-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 20, 2018 lúc 06:54 PM
-- Phiên bản máy phục vụ: 10.1.37-MariaDB
-- Phiên bản PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanao`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `tenkhachhang` varchar(200) NOT NULL,
  `sodienthoai` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `diachi` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`id`, `tenkhachhang`, `sodienthoai`, `email`, `diachi`) VALUES
(112, 'dgfdsfg', 876543, 'rt', 'gdfdfg'),
(113, 'rerer', 6543, 'edfdfd', 'fasfd'),
(114, 'rere', 234567, 'rerer', '2345df'),
(115, 'trt', 2345, 'rere', 'qrewq'),
(116, 'trt', 2345, 'rere', 'qrewq'),
(117, 'trt', 2345, 'rere', 'qre545'),
(118, 'trwe', 2147483647, 'fdfdf', 'zfdv'),
(119, 'rêr', 3456, 'sdfsdf', 'dfsf'),
(120, 'rêr', 3456, 'sdfsdf', 'dfsf'),
(121, 'dsd', 7373, 'sds@gmail.com', 'sda'),
(122, 'duyanh', 0, 'email', 'diachi'),
(123, 'duyanh', 34344343, 'email', 'diachi'),
(124, 'duyanh', 34344343, 'email', 'diachi'),
(125, 'duyanh', 34344343, 'email@gmail.com', 'diachi'),
(126, 'duyanh', 34344343, 'email@gmail.com', 'diachi'),
(127, 'duyanh', 34344343, 'danhy989@gmail.com', 'diachi'),
(128, 'duyanh', 34344343, 'danhy989@gmail.com', 'diachi'),
(129, 'duyanh', 34344343, 'danhy989@gmail.com', 'diachi'),
(130, 'duyanh', 34344343, 'danhy989@gmail.com', 'diachi'),
(131, 'duyanh', 34344343, 'danhy989@gmail.com', 'diachi'),
(132, 'duyanh', 34344343, 'danhy989@gmail.com', 'diachi'),
(133, 'sd', 7373, 'sds', 'sds'),
(134, 'testlan2', 12345, 'dasd@gmail.com', '12121'),
(135, 'dsds', 23232, '12121@gmail.com', 'fdfdffdd'),
(136, 'dfdd', 3337373, '12121@gmail.com', 'dfdffdfd'),
(137, 'sds', 737, 'ssds@gmail.com', '121212'),
(138, 'dfdf', 73277, 'sdassa@gmail.com', '121212'),
(139, 'sdas', 3232323, 'asdsada@gmail.com', 'asdsada@gmail.com'),
(140, 'sadsda', 232322, 'asdsa@gmail.com', 'asdsa@gmail.com'),
(141, 'fsdfdfs', 732737, 'dá@gmail.com', 'dá@gmail.com'),
(142, 'dfdff', 2147483647, 'dasds@gmail.com', 'dasds@gmail.com'),
(143, 'sdsd', 7373737, '43434@gmail.com', '43434@gmail.com'),
(144, 'sds', 7373, '232322@gmail.com', '232322@gmail.com'),
(145, 'sds', 7373, '232322@gmail.com', '232322@gmail.com'),
(146, 'sds', 7373, '232322@gmail.com', '232322@gmail.com'),
(147, 'sds', 7373, '232322@gmail.com', '232322@gmail.com'),
(148, 'sds', 7373, '232322@gmail.com', '232322@gmail.com'),
(149, 'sds', 737377, 'sdsa@gmail.com', 'sdsa@gmail.com'),
(150, 'sds', 737377, 'sdsa@gmail.com', 'sdsa@gmail.com'),
(151, 'sds', 737377, 'sdsa@gmail.com', 'sdsa@gmail.com'),
(152, 'sds', 737377, 'sdsa@gmail.com', 'sdsa@gmail.com'),
(153, 'sdsad', 723723237, 'sadsadada@gmail.com', 'sadsadada@gmail.com'),
(154, 'sdsad', 723723237, 'sadsadada@gmail.com', 'sadsadada@gmail.com'),
(155, 'sdsad', 723723237, 'sadsadada@gmail.com', 'sadsadada@gmail.com'),
(156, 'sdsad', 723723237, 'sadsadada@gmail.com', 'sadsadada@gmail.com'),
(157, 'sdsd', 2323, 'sds@gmail.com', 'sds@gmail.com'),
(158, 'sdsd', 2323, 'sds@gmail.com', 'sds@gmail.com'),
(159, 'sdsd', 2323, 'sds@gmail.com', 'sds@gmail.com'),
(160, 'sdsd', 2323, 'sds@gmail.com', 'sds@gmail.com'),
(161, 'sdsd', 3343, 'sdsd@gmail.com', 'sdsd@gmail.com'),
(162, 'sdsd', 3343, 'sdsd@gmail.com', 'sdsd@gmail.com'),
(163, 'sdsds', 2322121, 'dsd@gmail.com', 'dsd@gmail.com'),
(164, 'sdasd', 3434343, '121@gmail.com', '121@gmail.com'),
(165, 'sdad', 7237233, 'sdsad@gmail.com', 'sdsad@gmail.com'),
(166, 'ádsad', 12122343, 'danhy232@gmail.com', 'danhy232@gmail.com'),
(167, 'sdsd', 343434, 'dasds@gmail.com', 'dasds@gmail.com'),
(168, 'mua lan cuoi', 1234, 'dsds@gmail.com', 'dsds@gmail.com'),
(169, 'mua lan cuoi', 1234, 'dsds@gmail.com', 'dsds@gmail.com'),
(170, 'ddd', 7373, 'sdsd@gmail.com', 'sdsd@gmail.com'),
(171, 'sdsad', 7232737, '121212@gmail.com', '121212@gmail.com'),
(172, 'sdsad', 7232737, '121212@gmail.com', '121212@gmail.com'),
(173, 'sdsad', 2147483647, 'sdada@gmail.com', 'sdada@gmail.com'),
(174, 'sdsd', 737373, '3434@gmail.com', '3434@gmail.com'),
(175, 'sds', 2372327, '3434@gmail.com', '3434@gmail.com'),
(176, 'sdsd', 73737, 'sdsd@gmail.com', 'sdsd@gmail.com'),
(177, 'sdsd', 73737, 'sdsd@gmail.com', 'sdsd@gmail.com'),
(178, 'sdsd', 73737, 'sdsd@gmail.com', 'sdsd@gmail.com'),
(179, 'sdsd', 73737, 'sdsd@gmail.com', 'sdsd@gmail.com'),
(180, 'sdsd', 73737, 'sdsd@gmail.com', 'sdsd@gmail.com'),
(181, 'sdsd', 73737, 'sdsd@gmail.com', 'sdsd@gmail.com'),
(182, 'sdsd', 73737, 'sdsd@gmail.com', 'sdsd@gmail.com'),
(183, 'sdsd', 73737, 'sdsd@gmail.com', 'sdsd@gmail.com'),
(184, 'sdsd', 73737, 'sdsd@gmail.com', 'sdsd@gmail.com'),
(185, 'sdsd', 73737, 'sdsd@gmail.com', 'sdsd@gmail.com'),
(186, 'sdsd', 73737, 'sdsd@gmail.com', 'sdsd@gmail.com'),
(187, 'sdsda', 34343343, 'sdsd@gmail.com', 'sdsd@gmail.com'),
(188, 'dsdsdsds', 2147483647, 'sds@gmail.com', 'sds@gmail.com'),
(189, 'sdsd', 23723, 'sdsd@gmail.com', 'sdsd@gmail.com'),
(190, 'sds', 73737373, 'ewe@gmail.com', 'ewe@gmail.com'),
(191, 'DUY ANH', 7373, 'asdsadds@gmail.com', 'asdsadds@gmail.com'),
(192, 'sdsda', 273273, 'sdsd@gmail.com', 'sdsd@gmail.com'),
(193, 'sdsda', 273273, 'sdsd@gmail.com', 'sdsd@gmail.com'),
(194, 'sdsda', 737337, 'sdsdds@gmail.com', 'sdsdds@gmail.com'),
(195, 'dfdf', 121212, 'dsdsdd', 'dsdsdd'),
(196, '343443', 3434, '33', '34343'),
(197, '343443', 3434, '33', '34343');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=198;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
