package com.example.extend_exercise_1117;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.databinding.DataBindingUtil;
import android.annotation.SuppressLint;
import android.app.*;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import com.example.extend_exercise_1117.databinding.ActivityMainBinding;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    ArrayList<JobInWeek> arrJob = new ArrayList<JobInWeek>();
    //Khai báo ArrayAdapter cho ListView
    ArrayAdapter<JobInWeek> adapter = null;
    Calendar cal;
    Date dateFinish;
    Date hourFinish;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getFormWidgets();
        getDefaultInfor();
        addEventFormWidgets();
        binding.showPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu();
            }
        });
        binding.btncongviec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processAddJob();
            }
        });
    }

    private void showPopupMenu() {
        // khơi tạo popupmenu với vị trí nằm phía dưới đối tượng tvContext
        // tvContext có thể là textview, imageview, button ...
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, binding.showPopupMenu);
        // gán giao diện cho popup menu
        popupMenu.getMenuInflater().inflate(R.menu.my_menu, popupMenu.getMenu());
        // bắt sự kiện click item trên menu
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_share:
                        Toast.makeText(MainActivity.this,
                                "SHARE", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_search:
                        Toast.makeText(MainActivity.this,
                                "CATEGORY", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    private void initData() {
        JobInWeek jobInWeek = new JobInWeek("Studying", "Android Programming", new Date(2009 - 1900, 8 - 1, 8), Calendar.getInstance().getTime());
        JobInWeek jobInWeek1 = new JobInWeek("Relax", "Listening Music", new Date(2009 - 1900, 8 - 1, 8), Calendar.getInstance().getTime());
        JobInWeek jobInWeek2 = new JobInWeek("Lunch", "Eating", new Date(2007 - 1900, 7 - 1, 8), Calendar.getInstance().getTime());
        arrJob.add(jobInWeek);
        arrJob.add(jobInWeek1);
        arrJob.add(jobInWeek2);
        arrJob.addAll(AppDatabase.getInMemoryDatabase(this).jobInWeekDao().getAll());
        adapter.notifyDataSetChanged();
    }

    /**
     * hàm dùng để load các control theo Id
     */
    private void getFormWidgets() {
        adapter = new ArrayAdapter<JobInWeek>
                (this,
                        android.R.layout.simple_list_item_1,
                        arrJob);
        binding.lvcongviec.setAdapter(adapter);
        initData();
    }

    /**
     * Hàm lấy các thông số mặc định khi lần đầu tiền chạy ứng dụng
     */
    public void getDefaultInfor() {
        //lấy ngày hiện tại của hệ thống
        cal = Calendar.getInstance();
        SimpleDateFormat dft = null;

        //Định dạng ngày / tháng /năm
        dft = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String strDate = dft.format(cal.getTime());
        //hiển thị lên giao diện
        binding.txtdate.setText(strDate);
        //Định dạng giờ phút am/pm
        dft = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        String strTime = dft.format(cal.getTime());
        //đưa lên giao diện
        binding.txttime.setText(strTime);
        //lấy giờ theo 24 để lập trình theo Tag
        dft = new SimpleDateFormat("HH:mm", Locale.getDefault());
        binding.txttime.setTag(dft.format(cal.getTime()));
        binding.editcongviec.requestFocus();
        //gán cal.getTime() cho ngày hoàn thành và giờ hoàn thành
        dateFinish = cal.getTime();
        hourFinish = cal.getTime();
    }

    private void addEventFormWidgets() {
        binding.btndate.setOnClickListener(new MyButtonEvent());
        binding.btntime.setOnClickListener(new MyButtonEvent());
        binding.btncongviec.setOnClickListener(new MyButtonEvent());
        binding.lvcongviec.setOnItemClickListener(new MyListViewEvent());
        binding.lvcongviec.setOnItemLongClickListener(new MyListViewEvent());
    }

    /**
     * Class sự kiện của các Button
     */
    private class MyButtonEvent implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btndate:
                    showDatePickerDialog();
                    break;
                case R.id.btntime:
                    showTimePickerDialog();
                    break;
                case R.id.btncongviec:
                    processAddJob();
                    break;
            }
        }
    }

    /**
     * Class sự kiện của ListView
     */
    private class MyListViewEvent implements
            AdapterView.OnItemClickListener,
            AdapterView.OnItemLongClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            //Hiển thị nội dung công việc tại vị trí thứ arg2
            binding.editcongviec.setText(arrJob.get(i).getTitle());
            binding.editnoidung.setText(arrJob.get(i).getDesciption());
            binding.txtdate.setText(arrJob.get(i).getDateFormat(arrJob.get(i).getDateFinish()));
            binding.txttime.setText(arrJob.get(i).getHourFormat(arrJob.get(i).getHourFinish()));

        }

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            //Xóa vị trí thứ arg2
            arrJob.remove(i);
            adapter.notifyDataSetChanged();
            return false;
        }
    }

    /**
     * Hàm hiển thị DatePicker dialog
     */
    public void showDatePickerDialog() {
        DatePickerDialog.OnDateSetListener callback = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        //Mỗi lần thay đổi ngày tháng năm ,cập nhật lại Date
                String s = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                binding.txtdate.setText(s);
        //Lưu vết lại biến ngày hoàn thành
                cal.set(year, monthOfYear, dayOfMonth);
                dateFinish = cal.getTime();
            }
        };
        //các lệnh dưới này xử lý ngày giờ trong DatePickerDialog
        //sẽ giống với trên TextView khi mở lên
        String s = binding.txtdate.getText() + "";
        String strArrtmp[] = s.split("/");
        int ngay = Integer.parseInt(strArrtmp[0]);
        int thang = Integer.parseInt(strArrtmp[1]) - 1;
        int nam = Integer.parseInt(strArrtmp[2]);
        DatePickerDialog pic = new DatePickerDialog(
                MainActivity.this,
                callback, nam, thang, ngay);
        pic.setTitle("Chọn ngày hoàn thành");
        pic.show();
    }

    /**
     * Hàm hiển thị TimePickerDialog
     */
    public void showTimePickerDialog() {
        TimePickerDialog.OnTimeSetListener callback = new TimePickerDialog.OnTimeSetListener() {
            @SuppressLint("SetTextI18n")
            public void onTimeSet(TimePicker view,
                                  int hourOfDay, int minute) {
                //Xử lý lưu giờ và AM,PM
                String s = hourOfDay + ":" + minute;
                int hourTam = hourOfDay;
                if (hourTam > 12)
                    hourTam = hourTam - 12;
                binding.txttime.setText
                        (hourTam + ":" + minute + (hourOfDay > 12 ? " PM" : " AM"));
                //lưu giờ thực vào tag
                binding.txttime.setTag(s);
                //lưu vết lại giờ vào hourFinish
                cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
                cal.set(Calendar.MINUTE, minute);
                hourFinish = cal.getTime();
            }
        };
        //các lệnh dưới này xử lý ngày giờ trong TimePickerDialog
        //sẽ giống với trên TextView khi mở lên
        String s = binding.txttime.getTag() + "";
        String strArr[] = s.split(":");
        int gio = Integer.parseInt(strArr[0]);
        int phut = Integer.parseInt(strArr[1]);
        TimePickerDialog time = new TimePickerDialog(
                MainActivity.this, callback, gio, phut, true);
        time.setTitle("Chọn giờ hoàn thành");
        time.show();

    }

    /**
     * Hàm xử lý đưa công việc vào ListView khi nhấn nút Thêm Công việc
     */
    public void processAddJob() {
        String title = binding.editcongviec.getText() + "";
        String description = binding.editnoidung.getText() + "";
        JobInWeek job = new JobInWeek(title, description, dateFinish, hourFinish);
        for (int i=0;i<arrJob.size();i++){
            if(title.compareTo(arrJob.get(i).getTitle())==0){
                Toast.makeText(this, "Đã tồn tại công việc trong database", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        AppDatabase.getInMemoryDatabase(this).jobInWeekDao().insertJobInWeek(job);
        arrJob.add(job);
        adapter.notifyDataSetChanged();
        //sau khi cập nhật thì reset dữ liệu và cho focus tới editCV
        binding.editcongviec.setText("");
        binding.editnoidung.setText("");
        binding.editcongviec.requestFocus();

    }

    // khoi tao option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // khởi tạo menu từ file my_menu trong thư mục res/menu
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Bắt sự kiện click menu thông qua menu id
        switch (item.getItemId()) {
            case R.id.menu_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.close:
                androidx.appcompat.app.AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("Hỏi thoát chương trình");
                builder.setMessage("Bạn muốn thoát chương trình?");
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.create().show();
        }
        return super.onOptionsItemSelected(item);
    }
}