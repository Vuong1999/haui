IF EXISTS (SELECT * FROM sys.change_tracking_tables WHERE object_id = OBJECT_ID(N'[dbo].[Account]')) 
   ALTER TABLE [dbo].[Account] 
   DISABLE  CHANGE_TRACKING
GO
