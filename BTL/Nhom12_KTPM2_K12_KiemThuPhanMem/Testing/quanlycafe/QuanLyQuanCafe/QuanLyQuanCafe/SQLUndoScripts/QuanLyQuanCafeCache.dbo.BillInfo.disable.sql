IF EXISTS (SELECT * FROM sys.change_tracking_tables WHERE object_id = OBJECT_ID(N'[dbo].[BillInfo]')) 
   ALTER TABLE [dbo].[BillInfo] 
   DISABLE  CHANGE_TRACKING
GO
