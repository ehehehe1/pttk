create database QLCH1;
use QLCH1;

create table CHUCNANG(
	MACN varchar(10) primary key,
	TENCN nvarchar(255),
	TRANGTHAI int NOT NULL
)

create table NHOMQUYEN(
	MAQ varchar(10) primary key,
	TENQUYEN varchar(50),
	TRANGTHAI int
)

create table CT_QUYEN(
	MAQ varchar(10),
	MACN varchar(10),
	HANHDONG nvarchar(255) 
	primary key (MAQ, MACN),
	foreign key (MAQ) references NHOMQUYEN(MAQ),
	foreign key (MACN) references CHUCNANG(MACN)

)

create table KHACHHANG(
	MAKH varchar(10) primary key,
	HOTEN nvarchar(255),
	TENDN nvarchar(255) NOT NULL,
	MATKHAU nvarchar(255) NOT NULL,
	EMAIL varchar(255) NOT NULL,
	SDT varchar(20) NOT NULL,
	DIACHI nvarchar(255) NOT NULL,
	TRANGTHAI int NOT NULL
)

create table NVIEN(
	MANV	varchar(10) primary key,
	TENDN	nvarchar(255) NOT NULL,
	MATKHAU varchar(255),
	DIACHI	nvarchar(255),
	SDT		varchar(255),
	MAQ		varchar(10),
	TRANGTHAI int NOT NULL
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
	GIAVON	int NOT NULL,
	GIABAN	int NOT NULL,
	TRANGTHAI int NOT NULL
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
	MACTSP varchar(20) primary key,		--	mactsp = masp + mamau + masize
	MASP varchar(10)	foreign key references SANPHAM(MASP),
	MAMAU varchar(10)	foreign key references MAUSAC(MAMAU),
	MASIZE varchar(10)	foreign key references SIZE(MASIZE),
	SOLUONG int,
	TRANGTHAI int
)

create table DONHANG(
	MADH		varchar(10) primary key,
	MAKH		varchar(10)	foreign key references KHACHHANG(MAKH),
	TONGTIEN	int,
	PTTT		int,
	NGAYDH		Datetime,
	TRANGTHAI	int,
	--NGAYNH		Datetime,
)

create table CT_DONHANG(
	MADH	varchar(10),
	MACTSP	varchar(20),
	TENSP	nvarchar(255),
	SOLUONG	int,
	DONGIA	int,
	primary key (MADH, MACTSP),
	foreign key (MADH) references DONHANG(MADH),
	foreign key (MACTSP) references CT_SANPHAM(MACTSP)
	
)

create table PHIEUNHAP(
	MAPHIEU		varchar(10) primary key,
	THOIGIAN	Datetime,
	MANCC		varchar(10)	foreign key references NCC(MANCC),		
	MANV		varchar(10)	foreign key references NVIEN(MANV),
	TONGTIEN	int,
	TRANGTHAI	int,
)

create table CT_PHIEUNHAP(
	MAPHIEU	varchar(10),
	MACTSP	varchar(20),
	SOLUONG	int,
	DONGIA	int,
	primary key (MAPHIEU, MACTSP),
	foreign key (MAPHIEU) references PHIEUNHAP(MAPHIEU),
	foreign key (MACTSP) references CT_SANPHAM(MACTSP)
)

create table GIOHANG(
	MAKH	varchar(10),
	MACTSP	varchar(20),
	SOLUONG	int,
	GIABAN int,
	TRANGTHAI	int
	primary key (MAKH, MACTSP)
	foreign key (MAKH) references KHACHHANG(MAKH),
	foreign key (MACTSP) references CT_SANPHAM(MACTSP)
)

create table PHIEUTRA(
	MAPHIEUTRA	varchar(10) primary key,
	MADH		varchar(10) foreign key references DONHANG(MADH),
	MACTSP		varchar(20) foreign key references CT_SANPHAM(MACTSP),
	SOLUONG		int,
	LYDO		nvarchar(255),
	NGAYTRA		Datetime,
	NGUOITAO	varchar(10) foreign key references NVIEN(MANV)
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
('giohang', 'Quản lý giỏ hàng', 0);

insert into NHOMQUYEN(MAQ, TENQUYEN, TRANGTHAI) values
(1, 'Quản lý kho', 1),
(2, 'Nhân viên bán hàng', 1),
(3, 'Khách hàng', 1),
(4, 'admin', 1);


insert into CT_QUYEN(MAQ, MACN, HANHDONG) values
(1, 'nhaphang', 'taomoi'), (1, 'nhaphang', 'xoa'), (1, 'nhaphang', 'capnhat'), (1, 'nhaphang', 'hienthi'), 
(1, 'sanpham', 'taomoi'), (1, 'sanpham', 'xoa'), (1, 'sanpham', 'capnhat'), (1, 'sanpham', 'hienthi'), 
(1, 'nhacungcap', 'taomoi'), (1, 'nhacungcap', 'xoa'), (1, 'nhacungcap', 'capnhat'), (1, 'nhacungcap', 'hienthi'), 
(1, 'thuoctinh', 'taomoi'), (1, 'thuoctinh', 'xoa'), (1, 'thuoctinh', 'capnhat'), (1, 'thuoctinh', 'hienthi'), 
(1, 'thongke', 'taomoi'), (1, 'thongke', 'xoa'), (1, 'thongke', 'capnhat'), (1, 'thongke', 'hienthi'),

(2, 'khachhang', 'taomoi'), (2, 'khachhang', 'xoa'), (2, 'khachhang', 'capnhat'), (2, 'khachhang', 'hienthi'), 
(2, 'donhang', 'xoa'), (2, 'donhang', 'duyet'), (2, 'donhang', 'hienthi'), 
(2, 'thongke', 'taomoi'), (2, 'thongke', 'xoa'), (2, 'thongke', 'capnhat'), (2, 'thongke', 'hienthi'), 
(2, 'sanpham', 'hienthi'), (2, 'thuoctinh', 'hienthi'), 

(3, 'khachhang', 'taomoi'), (3, 'khachhang', 'capnhat'), (3, 'khachhang', 'hienthi'),
(3, 'donhang', 'taomoi'), (3, 'donhang', 'xoa'), (3, 'donhang', 'duyet'), (3, 'donhang', 'hienthi'), 
(3, 'giohang', 'them'), (3, 'giohang', 'xoa'), (3, 'giohang', 'capnhat'), (3, 'giohang', 'hienthi'),
(3, 'sanpham', 'hienthi'), (3, 'thuoctinh', 'hienthi'), 

(4, 'nhanvien', 'taomoi'), (4, 'nhanvien', 'xoa'), (4, 'nhanvien', 'capnhat'), (4, 'nhanvien', 'hienthi'), 
(4, 'nhomquyen', 'taomoi'), (4, 'nhomquyen', 'xoa'), (4, 'nhomquyen', 'capnhat'), (4, 'nhomquyen', 'hienthi');


insert into MAUSAC(MAMAU, TENMAU, TRANGTHAI) values
('01', 'Đỏ', 1), ('02', 'Đen', 1), ('03', 'Trắng', 1), ('04', 'Cam', 1), ('05', 'Vàng', 1), ('12', 'Tím', 1), 
('06', 'Xanh lam', 1), ('07', 'Xanh lá', 1), ('08', 'Hồng', 1), ('09', 'Tím', 1), ('10', 'Nâu', 1), ('11', 'Xám', 1); 

insert into SIZE(MASIZE, TENSIZE, TRANGTHAI) values
('01', 'Oversize', 1), ('02', 'S', 1), ('03', 'M', 1), ('04', 'L', 1), ('05', 'XL', 1), ('06', 'XXL', 1);

insert into LOAISP(MALOAI, TENLOAI, TRANGTHAI) values
('01', 'Đầm', 1), ('02', 'Áo', 1), ('03', 'Quần', 1), ('04', 'Chân váy', 1), ('05', 'Đồ bộ', 1), ('06', 'Áo dài', 1);

insert into SANPHAM(MASP, TENSP, MALOAI, GIAVON, GIABAN, TRANGTHAI) values
('00477', 'Đầm tay phồng cổ trụ', '01', 200000, 389000, 1), 
('00520', 'Đầm tay ngắn bèo viền ren', '01', 200000, 349000, 1), 
('00461', 'Đầm tay ngắn giả túi thanh lịch', '01', 200000, 359000, 1), 
('00472', 'Đầm tay ngắn cổ chữ U', '01', 200000, 349000, 1), 
('00465', 'Đầm 2 dây nơ', '01', 100000, 289000, 1),
('00733', 'Áo thun ngắn tay MESIYOU', '02', 100000, 279000, 1),
('00039', 'Quần tây trơn xẻ tà bên sợi', '03', 200000, 329000, 1), 
('00147', 'Chân váy ngắn xếp ly xòe', '04', 200000, 249000, 1); 
--('VDU00448', 'Đầm tay ngắn phối ren hoa kết đá', '', '01', 200000, 389000, 1), 
--('ATU00733', 'Áo thun ngắn tay MESIYOU', '', '02', 100000, 279000, 1), 
--('TAT00065', 'Áo thun ngắn tay YOU&ME', '', '02', 100000, 200000, 1), 
--('SMU00221', 'Sơ mi tay dài cổ bẻ trơn', '', '02', 100000, 249000, 1), 
--('ASU00691', 'Áo tay loe cột nơ lai ren', '', '02', 100000, 239000, 1), 
--('ALU00257', 'Áo len sát nách thêu gấu', '', '02', 100000, 239000, 1), 
--('QTR00039', 'Quần tây trơn xẻ tà bên sợi', '', '03', 200000, 329000, 1), 
--('QJB00099', 'Quần jeans dáng baggy xước lai', '', '03', 200000, 300000, 1), 
--('STU00039', 'Quần short tây xếp ly giả váy', '', '03', 80000, 179000, 1), 
--('QKU00016', 'Quần kaki trơn lai thường đơn giản ', '', '03', 200000, 269000, 1), 
--('CVD00100', 'Chân váy dài xẻ bên', '', '04', 200000, 249000, 1), 
--('CVD00104', 'Chân váy dài xanh trơn', '', '04', 200000, 269000, 1), 
--('CVN00147', 'Chân váy ngắn xếp ly xòe', '', '04', 200000, 249000, 1), 
--('CVN00131', 'Chân váy ngắn chữ A', '', '04', 100000, 219000, 1), 
--('CVD00086', 'Chân váy dài đai xẻ trước công sở', '', '04', 200000, 319000, 1), 
--('DBU00050', 'Đồ bộ thỏ Hello Sunday', '', '05', 200000, 0, 1), 
--('DBU00013', 'Đồ bộ xốp áo tay ngắn + quần ngắn kimono', '', '05', 900000, 189000, 1), 
--('DBU00002', 'Đồ bộ áo tay ngắn cổ vest 1 túi + quần ngắn', '', '05', 200000, 0, 1), 
--('ADU00014', 'Áo dài tay phồng hiện đại thướt tha', '', '06', 200000, 349000, 1), 
--('VDT00041', 'Đầm 2 dây trơn tay dài MESIYOU', '', '01', 200000, 300000, 1), 
--('YJU00016', 'Yếm jean túi hộp nút bên', '', '01', 200000, 300000, 1), 
--('VDU00432', 'Đầm 2 dây bảng to tầng tưa', '', '01', 200000, 269000, 1), 
--('KVU00025', 'Áo khoác vest tay dài thanh lịch', '', '02', 200000, 400000, 1), 
--('ALU00256', 'Áo len tay dày dập ly dày dặn', '', '02', 200000, 350000, 1), 
--('ASU00453', 'Áo kiểu 2 tầng xếp ly', '', '02', 100000, 150000, 1); 


insert into CT_SANPHAM(MACTSP, MASP, MAMAU, MASIZE, SOLUONG, TRANGTHAI) values
('004770104', '00477', '01', '04', 20, 1),
('004770102', '00477', '01', '02', 10, 1),
('004770103', '00477', '01', '03', 10, 1),
('004770202', '00477', '02', '02', 10, 1),
('004770203', '00477', '02', '03', 20, 1),
('004770204', '00477', '02', '04', 20, 1),
('004770302', '00477', '03', '02', 10, 1),
('004770303', '00477', '03', '03', 20, 1),
('004770304', '00477', '03', '04', 20, 1),
('005200101', '00520', '01', '01', 20, 1),
('005200201', '00520', '02', '01', 20, 1),
('005200601', '00520', '06', '01', 20, 1),
('004610201', '00461', '02', '01', 20, 1),
('004610301', '00461', '03', '01', 20, 1),
('004720201', '00472', '02', '01', 20, 1),
('004720501', '00472', '05', '01', 20, 1),
('004650101', '00465', '01', '01', 20, 1),
('004650102', '00465', '01', '02', 20, 1),
('004650201', '00465', '02', '01', 20, 1),
('004650202', '00465', '02', '02', 20, 1),
('007330201', '00733', '02', '01', 20, 1),
('007330301', '00733', '03', '01', 20, 1),
('000390201', '00039', '02', '01', 20, 1),
('000390501', '00039', '05', '01', 20, 1),
('001470101', '00147', '01', '01', 20, 1),
('001470102', '00147', '01', '02', 20, 1),
('001470201', '00147', '02', '01', 20, 1),
('001470202', '00147', '02', '02', 20, 1);





