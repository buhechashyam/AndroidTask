package com.example.materialuicomponent.recyclerview.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.materialuicomponent.R;
import com.example.materialuicomponent.databinding.ActivityExpendableRvactivityBinding;
import com.example.materialuicomponent.recyclerview.adapter.ExpandableAdapter;
import com.example.materialuicomponent.recyclerview.model.ExpandableData;

import java.util.ArrayList;

public class ExpendableRVActivity extends AppCompatActivity {

    ActivityExpendableRvactivityBinding binding;
    ArrayList<ExpandableData> languageInfos;
    ExpandableAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityExpendableRvactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        languageInfos = new ArrayList<ExpandableData>();
        languageInfos = getData();
        setSupportActionBar(binding.toolbar);

        binding.expandableRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ExpandableAdapter(languageInfos);
        binding.expandableRecyclerview.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //initialize menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_expendable_rvactivity, menu);

        //get a item from menu
        MenuItem searchViewItem = menu.findItem(R.id.menu_search);
        //initialize actionView
        SearchView searchView = (SearchView) searchViewItem.getActionView();
        searchView.setBackground(getDrawable(R.drawable.bg_profile));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                filterRecyclerView(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void filterRecyclerView(String newText) {
        ArrayList<ExpandableData> filerList = new ArrayList<ExpandableData>();


        for (ExpandableData data : languageInfos) {
            if (data.getTitle().toLowerCase().contains(newText)) {
                filerList.add(data);
            }
        }

        if (filerList.isEmpty()) {
            Toast.makeText(ExpendableRVActivity.this, "Data not matched", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setFilerList(filerList);
        }
    }

    private ArrayList<ExpandableData> getData() {
        ArrayList<ExpandableData> data = new ArrayList<ExpandableData>();

        data.add(new ExpandableData(R.drawable.ic_java, "Java", "JAVA is a programming language which is used in Android App Development. It is class based and object oriented programming whose syntax is influenced by C++. The primary goals of JAVA is to be simple, object-oriented, robust, secure and high level.", false));
        data.add(new ExpandableData(R.drawable.ic_kotlin, "Kotlin", "Kotlin is a cross-platform, statically typed, general-purpose high-level programming language with type inference. Kotlin is designed to interoperate fully with Java, and the JVM version of Kotlin's standard library depends on the Java Class Library, but type inference allows its syntax to be more concise.", false));
        data.add(new ExpandableData(R.drawable.ic_python, "Python", "Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation. Python is dynamically typed and garbage-collected. It supports multiple programming paradigms, including structured, object-oriented and functional programming", false));
        data.add(new ExpandableData(R.drawable.ic_c, "C", "C is a general-purpose computer programming language. It was created in the 1970s by Dennis Ritchie, and remains very widely used and influential. By design, C's features cleanly reflect the capabilities of the targeted CPUs.", false));
        data.add(new ExpandableData(R.drawable.ic_cplues, "C++", "C++ is a high-level, general-purpose programming language created by Danish computer scientist Bjarne Stroustrup", false));
        data.add(new ExpandableData(R.drawable.ic_csharp, "C#", "C# is a general-purpose high-level programming language supporting multiple paradigms. C# encompasses static typing, strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented, and component-oriented programming disciplines", false));
        data.add(new ExpandableData(R.drawable.ic_html, "HTML", "HyperText Markup Language or HTML is the standard markup language for documents designed to be displayed in a web browser. It defines the content and structure of web content. It is often assisted by technologies such as Cascading Style Sheets and scripting languages such as JavaScript. ", false));
        data.add(new ExpandableData(R.drawable.ic_css, "CSS", "Cascading Style Sheets is a style sheet language used for specifying the presentation and styling of a document written in a markup language such as HTML or XML. CSS is a cornerstone technology of the World Wide Web, alongside HTML and JavaScript. ", false));
        data.add(new ExpandableData(R.drawable.ic_php, "PHP", "PHP is a general-purpose scripting language geared towards web development. It was originally created by Danish-Canadian programmer Rasmus Lerdorf in 1993 and released in 1995. The PHP reference implementation is now produced by the PHP Group.", false));
        data.add(new ExpandableData(R.drawable.ic_java, "Java", "JAVA is a programming language which is used in Android App Development. It is class based and object oriented programming whose syntax is influenced by C++. The primary goals of JAVA is to be simple, object-oriented, robust, secure and high level.", false));
        data.add(new ExpandableData(R.drawable.ic_kotlin, "Kotlin", "Kotlin is a cross-platform, statically typed, general-purpose high-level programming language with type inference. Kotlin is designed to interoperate fully with Java, and the JVM version of Kotlin's standard library depends on the Java Class Library, but type inference allows its syntax to be more concise.", false));
        data.add(new ExpandableData(R.drawable.ic_python, "Python", "Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation. Python is dynamically typed and garbage-collected. It supports multiple programming paradigms, including structured, object-oriented and functional programming", false));
        data.add(new ExpandableData(R.drawable.ic_c, "C language", "C is a general-purpose computer programming language. It was created in the 1970s by Dennis Ritchie, and remains very widely used and influential. By design, C's features cleanly reflect the capabilities of the targeted CPUs.", false));
        data.add(new ExpandableData(R.drawable.ic_cplues, "C++", "C++ is a high-level, general-purpose programming language created by Danish computer scientist Bjarne Stroustrup", false));
        data.add(new ExpandableData(R.drawable.ic_csharp, "C#", "C# is a general-purpose high-level programming language supporting multiple paradigms. C# encompasses static typing, strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented, and component-oriented programming disciplines", false));
        data.add(new ExpandableData(R.drawable.ic_html, "HTML", "HyperText Markup Language or HTML is the standard markup language for documents designed to be displayed in a web browser. It defines the content and structure of web content. It is often assisted by technologies such as Cascading Style Sheets and scripting languages such as JavaScript. ", false));
        data.add(new ExpandableData(R.drawable.ic_css, "CSS", "Cascading Style Sheets is a style sheet language used for specifying the presentation and styling of a document written in a markup language such as HTML or XML. CSS is a cornerstone technology of the World Wide Web, alongside HTML and JavaScript. ", false));
        data.add(new ExpandableData(R.drawable.ic_java, "Java", "JAVA is a programming language which is used in Android App Development. It is class based and object oriented programming whose syntax is influenced by C++. The primary goals of JAVA is to be simple, object-oriented, robust, secure and high level.", false));
        data.add(new ExpandableData(R.drawable.ic_kotlin, "Kotlin", "Kotlin is a cross-platform, statically typed, general-purpose high-level programming language with type inference. Kotlin is designed to interoperate fully with Java, and the JVM version of Kotlin's standard library depends on the Java Class Library, but type inference allows its syntax to be more concise.", false));
        data.add(new ExpandableData(R.drawable.ic_python, "Python", "Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation. Python is dynamically typed and garbage-collected. It supports multiple programming paradigms, including structured, object-oriented and functional programming", false));
        data.add(new ExpandableData(R.drawable.ic_c, "C", "C is a general-purpose computer programming language. It was created in the 1970s by Dennis Ritchie, and remains very widely used and influential. By design, C's features cleanly reflect the capabilities of the targeted CPUs.", false));
        data.add(new ExpandableData(R.drawable.ic_cplues, "C++", "C++ is a high-level, general-purpose programming language created by Danish computer scientist Bjarne Stroustrup", false));
        data.add(new ExpandableData(R.drawable.ic_csharp, "C#", "C# is a general-purpose high-level programming language supporting multiple paradigms. C# encompasses static typing, strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented, and component-oriented programming disciplines", false));
        data.add(new ExpandableData(R.drawable.ic_html, "HTML", "HyperText Markup Language or HTML is the standard markup language for documents designed to be displayed in a web browser. It defines the content and structure of web content. It is often assisted by technologies such as Cascading Style Sheets and scripting languages such as JavaScript. ", false));
        data.add(new ExpandableData(R.drawable.ic_css, "CSS", "Cascading Style Sheets is a style sheet language used for specifying the presentation and styling of a document written in a markup language such as HTML or XML. CSS is a cornerstone technology of the World Wide Web, alongside HTML and JavaScript. ", false));
        data.add(new ExpandableData(R.drawable.ic_php, "PHP", "PHP is a general-purpose scripting language geared towards web development. It was originally created by Danish-Canadian programmer Rasmus Lerdorf in 1993 and released in 1995. The PHP reference implementation is now produced by the PHP Group.", false));
        data.add(new ExpandableData(R.drawable.ic_java, "Java", "JAVA is a programming language which is used in Android App Development. It is class based and object oriented programming whose syntax is influenced by C++. The primary goals of JAVA is to be simple, object-oriented, robust, secure and high level.", false));
        data.add(new ExpandableData(R.drawable.ic_kotlin, "Kotlin", "Kotlin is a cross-platform, statically typed, general-purpose high-level programming language with type inference. Kotlin is designed to interoperate fully with Java, and the JVM version of Kotlin's standard library depends on the Java Class Library, but type inference allows its syntax to be more concise.", false));
        data.add(new ExpandableData(R.drawable.ic_python, "Python", "Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation. Python is dynamically typed and garbage-collected. It supports multiple programming paradigms, including structured, object-oriented and functional programming", false));
        data.add(new ExpandableData(R.drawable.ic_c, "C language", "C is a general-purpose computer programming language. It was created in the 1970s by Dennis Ritchie, and remains very widely used and influential. By design, C's features cleanly reflect the capabilities of the targeted CPUs.", false));
        data.add(new ExpandableData(R.drawable.ic_cplues, "C++", "C++ is a high-level, general-purpose programming language created by Danish computer scientist Bjarne Stroustrup", false));
        data.add(new ExpandableData(R.drawable.ic_csharp, "C#", "C# is a general-purpose high-level programming language supporting multiple paradigms. C# encompasses static typing, strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented, and component-oriented programming disciplines", false));
        data.add(new ExpandableData(R.drawable.ic_html, "HTML", "HyperText Markup Language or HTML is the standard markup language for documents designed to be displayed in a web browser. It defines the content and structure of web content. It is often assisted by technologies such as Cascading Style Sheets and scripting languages such as JavaScript. ", false));
        data.add(new ExpandableData(R.drawable.ic_css, "CSS", "Cascading Style Sheets is a style sheet language used for specifying the presentation and styling of a document written in a markup language such as HTML or XML. CSS is a cornerstone technology of the World Wide Web, alongside HTML and JavaScript. ", false));
        data.add(new ExpandableData(R.drawable.ic_java, "Java", "JAVA is a programming language which is used in Android App Development. It is class based and object oriented programming whose syntax is influenced by C++. The primary goals of JAVA is to be simple, object-oriented, robust, secure and high level.", false));
        data.add(new ExpandableData(R.drawable.ic_kotlin, "Kotlin", "Kotlin is a cross-platform, statically typed, general-purpose high-level programming language with type inference. Kotlin is designed to interoperate fully with Java, and the JVM version of Kotlin's standard library depends on the Java Class Library, but type inference allows its syntax to be more concise.", false));
        data.add(new ExpandableData(R.drawable.ic_python, "Python", "Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation. Python is dynamically typed and garbage-collected. It supports multiple programming paradigms, including structured, object-oriented and functional programming", false));
        data.add(new ExpandableData(R.drawable.ic_c, "C", "C is a general-purpose computer programming language. It was created in the 1970s by Dennis Ritchie, and remains very widely used and influential. By design, C's features cleanly reflect the capabilities of the targeted CPUs.", false));
        data.add(new ExpandableData(R.drawable.ic_cplues, "C++", "C++ is a high-level, general-purpose programming language created by Danish computer scientist Bjarne Stroustrup", false));
        data.add(new ExpandableData(R.drawable.ic_csharp, "C#", "C# is a general-purpose high-level programming language supporting multiple paradigms. C# encompasses static typing, strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented, and component-oriented programming disciplines", false));
        data.add(new ExpandableData(R.drawable.ic_html, "HTML", "HyperText Markup Language or HTML is the standard markup language for documents designed to be displayed in a web browser. It defines the content and structure of web content. It is often assisted by technologies such as Cascading Style Sheets and scripting languages such as JavaScript. ", false));
        data.add(new ExpandableData(R.drawable.ic_css, "CSS", "Cascading Style Sheets is a style sheet language used for specifying the presentation and styling of a document written in a markup language such as HTML or XML. CSS is a cornerstone technology of the World Wide Web, alongside HTML and JavaScript. ", false));
        data.add(new ExpandableData(R.drawable.ic_php, "PHP", "PHP is a general-purpose scripting language geared towards web development. It was originally created by Danish-Canadian programmer Rasmus Lerdorf in 1993 and released in 1995. The PHP reference implementation is now produced by the PHP Group.", false));
        data.add(new ExpandableData(R.drawable.ic_java, "Java", "JAVA is a programming language which is used in Android App Development. It is class based and object oriented programming whose syntax is influenced by C++. The primary goals of JAVA is to be simple, object-oriented, robust, secure and high level.", false));
        data.add(new ExpandableData(R.drawable.ic_kotlin, "Kotlin", "Kotlin is a cross-platform, statically typed, general-purpose high-level programming language with type inference. Kotlin is designed to interoperate fully with Java, and the JVM version of Kotlin's standard library depends on the Java Class Library, but type inference allows its syntax to be more concise.", false));
        data.add(new ExpandableData(R.drawable.ic_python, "Python", "Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation. Python is dynamically typed and garbage-collected. It supports multiple programming paradigms, including structured, object-oriented and functional programming", false));
        data.add(new ExpandableData(R.drawable.ic_c, "C language", "C is a general-purpose computer programming language. It was created in the 1970s by Dennis Ritchie, and remains very widely used and influential. By design, C's features cleanly reflect the capabilities of the targeted CPUs.", false));
        data.add(new ExpandableData(R.drawable.ic_cplues, "C++", "C++ is a high-level, general-purpose programming language created by Danish computer scientist Bjarne Stroustrup", false));
        data.add(new ExpandableData(R.drawable.ic_csharp, "C#", "C# is a general-purpose high-level programming language supporting multiple paradigms. C# encompasses static typing, strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented, and component-oriented programming disciplines", false));
        data.add(new ExpandableData(R.drawable.ic_html, "HTML", "HyperText Markup Language or HTML is the standard markup language for documents designed to be displayed in a web browser. It defines the content and structure of web content. It is often assisted by technologies such as Cascading Style Sheets and scripting languages such as JavaScript. ", false));
        data.add(new ExpandableData(R.drawable.ic_css, "CSS", "Cascading Style Sheets is a style sheet language used for specifying the presentation and styling of a document written in a markup language such as HTML or XML. CSS is a cornerstone technology of the World Wide Web, alongside HTML and JavaScript. ", false));

        data.add(new ExpandableData(R.drawable.ic_php, "PHP", "PHP is a general-purpose scripting language geared towards web development. It was originally created by Danish-Canadian programmer Rasmus Lerdorf in 1993 and released in 1995. The PHP reference implementation is now produced by the PHP Group.", false));
        return data;
    }
}