IF EXISTS (SELECT * FROM sys.change_tracking_tables WHERE object_id = OBJECT_ID(N'[dbo].[Bill]')) 
   ALTER TABLE [dbo].[Bill] 
   DISABLE  CHANGE_TRACKING
GO
