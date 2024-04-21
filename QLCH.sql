create database QLCH;
use QLCH;

create table CHUCNANG(
	MACN varchar(10) primary key,
	TENCN nvarchar(50),
	TRANGTHAI smallint
)

create table NHOMQUYEN(
	MAQ varchar(10) primary key,
	TENQUYEN varchar(50),
	TRANGTHAI smallint
)

create table CT_QUYEN(
	MAQ varchar(10),
	MACN varchar(10),
	HANHDONG nvarchar(50) 
	--primary key(MAQ, MACN, HANHDONG),
	foreign key (MACN) references CHUCNANG(MACN),
	foreign key (MAQ) references NHOMQUYEN(MAQ),
)

create table TAIKHOAN (
	MATK		varchar(10) primary key,
	TENDN		varchar(50),
	MATKHAU		varchar(50),
	SDT			int,
	EMAIL		varchar(50),
	DIACHI		nvarchar(255),
	MAQ			varchar(10) foreign key references NHOMQUYEN(MAQ),
	TRANGTHAI	int
)

create table LOAISP(
	MALOAI	varchar(10) primary key,
	TENLOAI nvarchar(255),
	TRANGTHAI int 
)

create table SANPHAM(
	MASP	varchar(10) primary key,
	TENSP	nvarchar(255) NOT NULL,
	MALOAI	varchar(10) foreign key references LOAISP(MALOAI),
	SOLUONG int,			-- soluong tính tự động bằng tổng các số lượng sản phẩm của từng mã chi tiết sản phẩm
	TRANGTHAI smallint NOT NULL
)

create table MAUSAC(
	MAMAU	varchar(10) primary key,
	TENMAU	nvarchar(50),
	TRANGTHAI	int
)

create table SIZE(
	MASIZE		varchar(10)	primary key,
	TENSIZE		nvarchar(50),
	TRANGTHAI	int
)

create table NCC(
	MANCC	varchar(10) primary key,
	TENNCC	nvarchar(255),
	DIACHI	nvarchar(255),
	EMAIL	varchar(255),
	SDT		int,
	TRANGTHAI int
)

create table CT_SANPHAM(
	MACTSP varchar(30) primary key,		--	mactsp = masp + mamau + masize
	MASP varchar(10)	foreign key references SANPHAM(MASP),
	MAMAU varchar(10)	foreign key references MAUSAC(MAMAU),
	MASIZE varchar(10)	foreign key references SIZE(MASIZE),
	SOLUONG int,
	GIABAN	int,
	TRANGTHAI smallint
)

create table DONHANG(
	MADH		varchar(10) primary key,
	MATK		varchar(10)	foreign key references TAIKHOAN(MATK),
	TONGTIEN	money,
	PTTT		nvarchar(50),		-- "Tiền mặt", "Chuyển khoản"
	NGAYDH		Datetime,
	TRANGTHAI	smallint,
)

create table CT_DONHANG(
	MADH	varchar(10),
	MACTSP	varchar(30),
	TENSP	nvarchar(255),
	SOLUONG	int,
	DONGIA	money,
	THANHTIEN money,
	primary key (MADH, MACTSP),
	foreign key (MADH) references DONHANG(MADH),
	foreign key (MACTSP) references CT_SANPHAM(MACTSP)
	
)

create table PHIEUNHAP(
	MAPHIEU		varchar(10) primary key,
	NGAYTAO		Datetime,
	MANCC		varchar(10)	foreign key references NCC(MANCC),		
	MATK		varchar(10)	foreign key references TAIKHOAN(MATK),
	TONGTIEN	int,
	TRANGTHAI	int,
)

create table CT_PHIEUNHAP(
	MAPHIEU	varchar(10),
	MACTSP	varchar(30),
	SOLUONG	int,
	DONGIA	money,
	THANHTIEN money,
	primary key (MAPHIEU, MACTSP),
	foreign key (MAPHIEU) references PHIEUNHAP(MAPHIEU),
	foreign key (MACTSP) references CT_SANPHAM(MACTSP)
)

insert into CHUCNANG(MACN, TENCN, TRANGTHAI) values 
('khachhang', 'Quản lý khách hàng', 0),
('nhacungcap', 'Quản lý nhà cung cấp', 0),
('nhanvien', 'Quản lý nhân viên', 0),
('nhaphang', 'Quản lý nhập hàng', 0),
('nhomquyen', 'Quản lý nhóm quyền', 0),
('sanpham', 'Quản lý sản phẩm', 0),
('thongke', 'Quản lý thống kê', 0),
('donhang', 'Quản lý đơn hàng', 0),
('giohang', 'Quản lý giỏ hàng', 0),
('thuoctinh', 'Quản lý thuộc tính', 0);

insert into NHOMQUYEN(MAQ, TENQUYEN, TRANGTHAI) values
(1, 'Quản lý kho', 1),
(2, 'Nhân viên bán hàng', 1),
(3, 'Khách hàng', 1),
(4, 'admin', 1);


insert into CT_QUYEN(MAQ, MACN, HANHDONG) values
(4, 'nhanvien', 'taomoi'), (4, 'nhanvien', 'xoa'), (4, 'nhanvien', 'capnhat'), (4, 'nhanvien', 'hienthi'), 
(4, 'nhomquyen', 'taomoi'), (4, 'nhomquyen', 'xoa'), (4, 'nhomquyen', 'capnhat'), (4, 'nhomquyen', 'hienthi'),

(3, 'khachhang', 'taomoi'), (3, 'khachhang', 'capnhat'), (3, 'khachhang', 'hienthi'),
(3, 'donhang', 'taomoi'), (3, 'donhang', 'xoa'), (3, 'donhang', 'duyet'), (3, 'donhang', 'hienthi'), 
(3, 'giohang', 'them'), (3, 'giohang', 'xoa'), (3, 'giohang', 'capnhat'), (3, 'giohang', 'hienthi'),
(3, 'sanpham', 'hienthi'), (3, 'thuoctinh', 'hienthi'),

(2, 'khachhang', 'taomoi'), (2, 'khachhang', 'xoa'), (2, 'khachhang', 'capnhat'), (2, 'khachhang', 'hienthi'), 
(2, 'donhang', 'xoa'), (2, 'donhang', 'duyet'), (2, 'donhang', 'hienthi'), 
(2, 'thongke', 'taomoi'), (2, 'thongke', 'xoa'), (2, 'thongke', 'capnhat'), (2, 'thongke', 'hienthi'), 
(2, 'sanpham', 'hienthi'), (2, 'thuoctinh', 'hienthi'),

(1, 'thuoctinh', 'taomoi'), (1, 'thuoctinh', 'xoa'), (1, 'thuoctinh', 'capnhat'), (1, 'thuoctinh', 'hienthi'),
(1, 'thongke', 'taomoi'), (1, 'thongke', 'xoa'), (1, 'thongke', 'capnhat'), (1, 'thongke', 'hienthi'),
(1, 'nhacungcap', 'taomoi'), (1, 'nhacungcap', 'xoa'), (1, 'nhacungcap', 'capnhat'), (1, 'nhacungcap', 'hienthi'),
(1, 'sanpham', 'taomoi'), (1, 'sanpham', 'xoa'), (1, 'sanpham', 'capnhat'), (1, 'sanpham', 'hienthi'),
(1, 'nhaphang', 'taomoi'), (1, 'nhaphang', 'xoa'), (1, 'nhaphang', 'capnhat'), (1, 'nhaphang', 'hienthi');


insert into MAUSAC(MAMAU, TENMAU, TRANGTHAI) values
('01', 'Đỏ', 1), ('02', 'Đen', 1), ('03', 'Trắng', 1), ('04', 'Cam', 1), ('05', 'Vàng', 1), ('12', 'Tím', 1), 
('06', 'Xanh lam', 1), ('07', 'Xanh lá', 1), ('08', 'Hồng', 1), ('09', 'Tím', 1), ('10', 'Nâu', 1), ('11', 'Xám', 1); 

insert into SIZE(MASIZE, TENSIZE, TRANGTHAI) values
('01', 'Oversize', 1), ('02', 'S', 1), ('03', 'M', 1), ('04', 'L', 1), ('05', 'XL', 1), ('06', 'XXL', 1);

insert into LOAISP(MALOAI, TENLOAI, TRANGTHAI) values
('01', 'Đầm', 1), ('02', 'Áo', 1), ('03', 'Quần', 1), ('04', 'Chân váy', 1), ('05', 'Đồ bộ', 1), ('06', 'Áo dài', 1);

insert into SANPHAM(MASP, TENSP, MALOAI, SOLUONG, TRANGTHAI) values
('S00477', 'Đầm tay phồng cổ trụ', '01', 140, 1), 
('S00520', 'Đầm tay ngắn bèo viền ren', '01', 60, 1), 
('S00461', 'Đầm tay ngắn giả túi thanh lịch', '01', 40, 1), 
('S00472', 'Đầm tay ngắn cổ chữ U', '01', 40, 1), 
('S00465', 'Đầm 2 dây nơ', '01', 80, 1),
('S00733', 'Áo thun ngắn tay MESIYOU', '02', 40, 1),
('S00039', 'Quần tây trơn xẻ tà bên sợi', '03', 40, 1), 
('S00147', 'Chân váy ngắn xếp ly xòe', '04', 80, 1); 
--('VDU00448', 'Đầm tay ngắn phối ren hoa kết đá', '', '01', 200000, 389000, 1), 
--('ATU00733', 'Áo thun ngắn tay MESIYOU', '', '02', 100000, 279000, 1), 
--('TAT00065', 'Áo thun ngắn tay YOU&ME', '', '02', 100000, 200000, 1), 
--('SMU00221', 'Sơ mi tay dài cổ bẻ trơn', '', '02', 100000, 249000, 1), 
--('ASU00691', 'Áo tay loe cột nơ lai ren', '', '02', 100000, 239000, 1), 
--('ALU00257', 'Áo len sát nách thêu gấu', '', '02', 100000, 239000, 1), 
--('CVN00131', 'Chân váy ngắn chữ A', '', '04', 100000, 219000, 1), 
--('CVD00086', 'Chân váy dài đai xẻ trước công sở', '', '04', 200000, 319000, 1), 
--('DBU00050', 'Đồ bộ thỏ Hello Sunday', '', '05', 200000, 0, 1), 
--('VDU00432', 'Đầm 2 dây bảng to tầng tưa', '', '01', 200000, 269000, 1), 
--('KVU00025', 'Áo khoác vest tay dài thanh lịch', '', '02', 200000, 400000, 1), 
--('ALU00256', 'Áo len tay dày dập ly dày dặn', '', '02', 200000, 350000, 1), 
--('ASU00453', 'Áo kiểu 2 tầng xếp ly', '', '02', 100000, 150000, 1); 


insert into CT_SANPHAM(MACTSP, MASP, MAMAU, MASIZE, SOLUONG, GIABAN, TRANGTHAI) values
('S004770104', 'S00477', '01', '04', 20, 200000, 1),
('S004770102', 'S00477', '01', '02', 10, 200000, 1),
('S004770103', 'S00477', '01', '03', 10, 200000, 1),
('S004770202', 'S00477', '02', '02', 10, 200000, 1),
('S004770203', 'S00477', '02', '03', 20, 100000, 1),
('S004770204', 'S00477', '02', '04', 20, 400000, 1),
('S004770302', 'S00477', '03', '02', 10, 300000, 1),
('S004770303', 'S00477', '03', '03', 20, 150000, 1),
('S004770304', 'S00477', '03', '04', 20, 120000, 1),
('S005200101', 'S00520', '01', '01', 20, 140000, 1),
('S005200201', 'S00520', '02', '01', 20, 160000, 1),
('S005200601', 'S00520', '06', '01', 20, 180000, 1),
('S004610201', 'S00461', '02', '01', 20, 200000, 1),
('S004610301', 'S00461', '03', '01', 20, 200000, 1),
('S004720201', 'S00472', '02', '01', 20, 200000, 1),
('S004720501', 'S00472', '05', '01', 20, 200000, 1),
('S004650101', 'S00465', '01', '01', 20, 200000, 1),
('S004650102', 'S00465', '01', '02', 20, 200000, 1),
('S004650201', 'S00465', '02', '01', 20, 300000, 1),
('S004650202', 'S00465', '02', '02', 20, 350000, 1),
('S007330201', 'S00733', '02', '01', 20, 200000, 1),
('S007330301', 'S00733', '03', '01', 20, 150000, 1),
('S000390201', 'S00039', '02', '01', 20, 100000, 1),
('S000390501', 'S00039', '05', '01', 20, 200000, 1),
('S001470101', 'S00147', '01', '01', 20, 100000, 1),
('S001470102', 'S00147', '01', '02', 20, 300000, 1),
('S001470201', 'S00147', '02', '01', 20, 400000, 1),
('S001470202', 'S00147', '02', '02', 20, 200000, 1);





