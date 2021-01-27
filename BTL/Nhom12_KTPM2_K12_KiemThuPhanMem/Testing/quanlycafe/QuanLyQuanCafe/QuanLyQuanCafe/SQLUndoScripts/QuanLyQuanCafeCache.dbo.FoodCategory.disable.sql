IF EXISTS (SELECT * FROM sys.change_tracking_tables WHERE object_id = OBJECT_ID(N'[dbo].[FoodCategory]')) 
   ALTER TABLE [dbo].[FoodCategory] 
   DISABLE  CHANGE_TRACKING
GO
