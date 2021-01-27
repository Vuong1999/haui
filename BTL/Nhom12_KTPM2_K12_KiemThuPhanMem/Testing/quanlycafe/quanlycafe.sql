USE [QuanLyQuanCafe]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 12/07/2017 23:34:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[UserName] [nvarchar](100) NOT NULL,
	[DisplayName] [nvarchar](100) NOT NULL,
	[PassWord] [nvarchar](1000) NOT NULL,
	[Type] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[UserName] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TableFood]    Script Date: 12/07/2017 23:34:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TableFood](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NOT NULL,
	[status] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[FoodCategory]    Script Date: 12/07/2017 23:34:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FoodCategory](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Food]    Script Date: 12/07/2017 23:34:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Food](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NOT NULL,
	[idCategory] [int] NOT NULL,
	[price] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Bill]    Script Date: 12/07/2017 23:34:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[DateCheckIn] [date] NOT NULL,
	[DateCheckOut] [date] NULL,
	[idTable] [int] NOT NULL,
	[status] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThongKe]    Script Date: 12/07/2017 23:34:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThongKe](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idFood] [int] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[idTable] [int] NOT NULL,
 CONSTRAINT [PK_ThongKe] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThanhToan]    Script Date: 12/07/2017 23:34:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThanhToan](
	[idThanhToan] [int] IDENTITY(1,1) NOT NULL,
	[idFoodThanhToan] [int] NOT NULL,
	[SoLuongThanhToan] [int] NOT NULL,
	[idTableThanhToan] [int] NOT NULL,
 CONSTRAINT [PK_ThanhToan] PRIMARY KEY CLUSTERED 
(
	[idThanhToan] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BillInfo]    Script Date: 12/07/2017 23:34:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BillInfo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idBill] [int] NOT NULL,
	[idFood] [int] NOT NULL,
	[count] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Default [DF__Account__Display__07020F21]    Script Date: 12/07/2017 23:34:15 ******/
ALTER TABLE [dbo].[Account] ADD  DEFAULT (N'Kter') FOR [DisplayName]
GO
/****** Object:  Default [DF__Account__PassWor__07F6335A]    Script Date: 12/07/2017 23:34:15 ******/
ALTER TABLE [dbo].[Account] ADD  DEFAULT ((0)) FOR [PassWord]
GO
/****** Object:  Default [DF__Account__Type__08EA5793]    Script Date: 12/07/2017 23:34:15 ******/
ALTER TABLE [dbo].[Account] ADD  DEFAULT ((0)) FOR [Type]
GO
/****** Object:  Default [DF__Bill__DateCheckI__1920BF5C]    Script Date: 12/07/2017 23:34:15 ******/
ALTER TABLE [dbo].[Bill] ADD  DEFAULT (getdate()) FOR [DateCheckIn]
GO
/****** Object:  Default [DF__Bill__status__1A14E395]    Script Date: 12/07/2017 23:34:15 ******/
ALTER TABLE [dbo].[Bill] ADD  DEFAULT ((0)) FOR [status]
GO
/****** Object:  Default [DF__BillInfo__count__1FCDBCEB]    Script Date: 12/07/2017 23:34:15 ******/
ALTER TABLE [dbo].[BillInfo] ADD  DEFAULT ((0)) FOR [count]
GO
/****** Object:  Default [DF__Food__name__1273C1CD]    Script Date: 12/07/2017 23:34:15 ******/
ALTER TABLE [dbo].[Food] ADD  DEFAULT (N'Chưa đặt tên') FOR [name]
GO
/****** Object:  Default [DF__Food__price__1367E606]    Script Date: 12/07/2017 23:34:15 ******/
ALTER TABLE [dbo].[Food] ADD  DEFAULT ((0)) FOR [price]
GO
/****** Object:  Default [DF__FoodCatego__name__0DAF0CB0]    Script Date: 12/07/2017 23:34:15 ******/
ALTER TABLE [dbo].[FoodCategory] ADD  DEFAULT (N'Chưa đặt tên') FOR [name]
GO
/****** Object:  Default [DF__TableFood__name__014935CB]    Script Date: 12/07/2017 23:34:15 ******/
ALTER TABLE [dbo].[TableFood] ADD  DEFAULT (N'Bàn chưa có tên') FOR [name]
GO
/****** Object:  Default [DF__TableFood__statu__023D5A04]    Script Date: 12/07/2017 23:34:15 ******/
ALTER TABLE [dbo].[TableFood] ADD  DEFAULT (N'Trống') FOR [status]
GO
/****** Object:  ForeignKey [FK__Bill__status__1B0907CE]    Script Date: 12/07/2017 23:34:15 ******/
ALTER TABLE [dbo].[Bill]  WITH CHECK ADD FOREIGN KEY([idTable])
REFERENCES [dbo].[TableFood] ([id])
GO
/****** Object:  ForeignKey [FK__BillInfo__count__20C1E124]    Script Date: 12/07/2017 23:34:15 ******/
ALTER TABLE [dbo].[BillInfo]  WITH CHECK ADD FOREIGN KEY([idBill])
REFERENCES [dbo].[Bill] ([id])
GO
/****** Object:  ForeignKey [FK__BillInfo__idFood__21B6055D]    Script Date: 12/07/2017 23:34:15 ******/
ALTER TABLE [dbo].[BillInfo]  WITH CHECK ADD FOREIGN KEY([idFood])
REFERENCES [dbo].[Food] ([id])
GO
/****** Object:  ForeignKey [FK__Food__price__145C0A3F]    Script Date: 12/07/2017 23:34:15 ******/
ALTER TABLE [dbo].[Food]  WITH CHECK ADD FOREIGN KEY([idCategory])
REFERENCES [dbo].[FoodCategory] ([id])
GO
/****** Object:  ForeignKey [FK_ThanhToan_Food]    Script Date: 12/07/2017 23:34:15 ******/
ALTER TABLE [dbo].[ThanhToan]  WITH CHECK ADD  CONSTRAINT [FK_ThanhToan_Food] FOREIGN KEY([idFoodThanhToan])
REFERENCES [dbo].[Food] ([id])
GO
ALTER TABLE [dbo].[ThanhToan] CHECK CONSTRAINT [FK_ThanhToan_Food]
GO
/****** Object:  ForeignKey [FK_ThanhToan_TableFood]    Script Date: 12/07/2017 23:34:15 ******/
ALTER TABLE [dbo].[ThanhToan]  WITH CHECK ADD  CONSTRAINT [FK_ThanhToan_TableFood] FOREIGN KEY([idTableThanhToan])
REFERENCES [dbo].[TableFood] ([id])
GO
ALTER TABLE [dbo].[ThanhToan] CHECK CONSTRAINT [FK_ThanhToan_TableFood]
GO
/****** Object:  ForeignKey [FK_ThongKe_Food]    Script Date: 12/07/2017 23:34:15 ******/
ALTER TABLE [dbo].[ThongKe]  WITH CHECK ADD  CONSTRAINT [FK_ThongKe_Food] FOREIGN KEY([idFood])
REFERENCES [dbo].[Food] ([id])
GO
ALTER TABLE [dbo].[ThongKe] CHECK CONSTRAINT [FK_ThongKe_Food]
GO
/****** Object:  ForeignKey [FK_ThongKe_TableFood]    Script Date: 12/07/2017 23:34:15 ******/
ALTER TABLE [dbo].[ThongKe]  WITH CHECK ADD  CONSTRAINT [FK_ThongKe_TableFood] FOREIGN KEY([idTable])
REFERENCES [dbo].[TableFood] ([id])
GO
ALTER TABLE [dbo].[ThongKe] CHECK CONSTRAINT [FK_ThongKe_TableFood]
GO
