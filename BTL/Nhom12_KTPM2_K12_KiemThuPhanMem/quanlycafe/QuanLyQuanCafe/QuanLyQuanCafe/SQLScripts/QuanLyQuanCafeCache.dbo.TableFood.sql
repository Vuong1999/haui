IF NOT EXISTS (SELECT * FROM sys.change_tracking_tables WHERE object_id = OBJECT_ID(N'[dbo].[TableFood]')) 
   ALTER TABLE [dbo].[TableFood] 
   ENABLE  CHANGE_TRACKING
GO
