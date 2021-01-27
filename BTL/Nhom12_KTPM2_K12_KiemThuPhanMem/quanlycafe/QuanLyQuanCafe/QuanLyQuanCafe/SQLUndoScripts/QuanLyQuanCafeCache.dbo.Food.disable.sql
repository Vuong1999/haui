IF EXISTS (SELECT * FROM sys.change_tracking_tables WHERE object_id = OBJECT_ID(N'[dbo].[Food]')) 
   ALTER TABLE [dbo].[Food] 
   DISABLE  CHANGE_TRACKING
GO
