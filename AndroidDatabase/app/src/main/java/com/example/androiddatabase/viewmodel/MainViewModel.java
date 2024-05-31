package com.example.androiddatabase.viewmodel;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.androiddatabase.roomdb.AppDatabase;
import com.example.androiddatabase.roomdb.dao.ProductDao;
import com.example.androiddatabase.roomdb.dao.StudentDao;
import com.example.androiddatabase.roomdb.entity.ProductEntity;
import com.example.androiddatabase.roomdb.entity.StudentEntity;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainViewModel extends AndroidViewModel {

    AppDatabase database;
    ProductDao productDao;
    StudentDao studentDao;

    static final ExecutorService service = Executors.newFixedThreadPool(10);
    Handler handler = new Handler(Looper.getMainLooper());


    public MainViewModel(Application application) {
        super(application);
        //database = Room.databaseBuilder(application, AppDatabase.class, "productsdb").allowMainThreadQueries().build();
        database = AppDatabase.getInstance(application);
        productDao = database.productDao();
        studentDao = database.studentDao();

    }

    //For Product Table
    MutableLiveData<List<ProductEntity>> _mProducts = new MutableLiveData<>();
    LiveData<List<ProductEntity>> mProducts = _mProducts;
    public LiveData<List<ProductEntity>> getAllProducts() {
        _mProducts.setValue(productDao.getAllProducts());
        return mProducts;
    }

    public void addProduct(ProductEntity product) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        productDao.addProduct(product);
                    }
                });

            }
        });
    }

    public void updateProductById(int id, String pname, String pDesc, String pPrice) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        productDao.updateProductById(id, pname, pDesc, pPrice);
                    }
                });
            }
        });

    }

    public void deleteProduct(ProductEntity product) {
        service.execute(new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        productDao.deleteProduct(product);
                    }
                });
            }
        });

    }

    //For Student Table
    MutableLiveData<List<StudentEntity>> _mStudents = new MutableLiveData<>();
    LiveData<List<StudentEntity>> mStudents = _mStudents;

    public void addStudent(StudentEntity student) {
        service.execute(new Runnable() {
            @Override
            public void run() {

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        studentDao.addStudent(student);
                    }
                });
            }
        });

    }

    public void updateStudent(StudentEntity student) {
        studentDao.updateStudent(student);
    }

    public LiveData<List<StudentEntity>> getAllStudent() {
        _mStudents.setValue(studentDao.getAllStudents());
        return mStudents;
    }

}
