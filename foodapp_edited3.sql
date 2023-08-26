use foodappdb;
use foodappdb1;
use foodappdb2;
create table nguoi_dung
(
	id int primary key auto_increment,
    first_name nvarchar(45) not null,
    last_name nvarchar(45) not null,
    tai_khoan nvarchar(45) not null,
    mat_khau nvarchar(100) not null,
    email nvarchar(45) not null,
    phone nvarchar(45) not null,
    avatar nvarchar(255),
    vai_tro nvarchar(10),
    active bit(1) default 1
);

create table loai_cua_hang
(
	id int primary key auto_increment,
    name nvarchar(45) not null
);

create table cua_hang
(
	id int primary key auto_increment,
    name nvarchar(45) not null,
    dia_chi nvarchar(255),
    image nvarchar(255),
    gia_van_chuyen decimal default 0,
    created_date datetime default now(),
    id_nguoi_dung int,
    foreign key(id_nguoi_dung) references nguoi_dung(id),
    id_loai_cua_hang int,
    foreign key(id_loai_cua_hang) references loai_cua_hang(id)
);

create table hoa_don
(
	id int primary key auto_increment,
    created_date datetime default now(),
    id_nguoi_dung int,
    foreign key(id_nguoi_dung) references nguoi_dung(id)
);

create table category
(
	id int primary key auto_increment,
    name nvarchar(45) not null
);

create table thuc_an
(
	id int primary key auto_increment,
    name nvarchar(45) not null,
    so_luong int not null,
    price decimal not null,
    image nvarchar(255),
    created_date datetime default now(),
    id_loai int,
    foreign key(id_loai) references category(id),
    id_cua_hang int,
    foreign key(id_cua_hang) references cua_hang(id)
);


create table hoa_don_chi_tiet
(
	id int primary key auto_increment,
    so_luong_mua int not null,
    gia_van_chuyen decimal not null,
    tong_tien decimal not null,
    khoang_cach double default 0,
    created_date datetime default now(),
    id_hoa_don int,
    foreign key(id_hoa_don) references hoa_don(id),
    id_thuc_an int,
    foreign key(id_thuc_an) references thuc_an(id)
);

create table danh_gia
(
	id int primary key auto_increment,
    noi_dung nvarchar(255),
    danh_gia int,
    created_date datetime default now(),
    id_nguoi_dung int,
    foreign key(id_nguoi_dung) references nguoi_dung(id),
    id_cua_hang int,
    foreign key(id_cua_hang) references cua_hang(id)
);

create table quy_dinh_van_chuyen
(
	id int primary key auto_increment,
    khoang_cach double not null,
    price decimal not null,
    id_cua_hang int,
    foreign key(id_cua_hang) references cua_hang(id)
);


drop table danh_gia;
drop table hoa_don_chi_tiet;
drop table hoa_don;
drop table thuc_an;
drop table cua_hang;
drop table nguoi_dung;
drop table category;