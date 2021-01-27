IF EXISTS (SELECT * FROM sys.change_tracking_tables WHERE object_id = OBJECT_ID(N'[dbo].[TableFood]')) 
   ALTER TABLE [dbo].[TableFood] 
   DISABLE  CHANGE_TRACKING
GO
