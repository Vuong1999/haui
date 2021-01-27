IF NOT EXISTS (SELECT * FROM sys.change_tracking_tables WHERE object_id = OBJECT_ID(N'[dbo].[FoodCategory]')) 
   ALTER TABLE [dbo].[FoodCategory] 
   ENABLE  CHANGE_TRACKING
GO
