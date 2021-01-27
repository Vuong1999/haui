IF NOT EXISTS (SELECT * FROM sys.change_tracking_tables WHERE object_id = OBJECT_ID(N'[dbo].[BillInfo]')) 
   ALTER TABLE [dbo].[BillInfo] 
   ENABLE  CHANGE_TRACKING
GO
