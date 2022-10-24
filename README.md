# Task-12B

Project in Android Studio to make a counter and display it on the screen with different Layouts and screen resolutions.

Instead of making 3 different projects, I have created 3 activities with buttons to navigate between them.

<details>

**<summary>Application Images</summary>**

Mobile:

<img src="resForReadme/mobile.gif">

Tablet:

<img src="resForReadme/tablet.gif">

</details>

## Functioning general (User view)

-   You will see a counter starting from 0.

-   You can increase the counter by +1 by pressing a button.

-   The counter value can be displayed using a `Toast`.

## Functioning technical

The program will be divided into the following sections:

-   ### **Java files** (Application Backend):

    -   **`MainActivity.java`** (`LinearLayout`)

        -   Main activity of the program, users will be able to see the counter, add +1 to the counter and display the value of the counter through a `Toast`. If the device is rotated horizontally, the counter value will be saved.

    -   **`RelativeLayoutActivity.java`** and **`ConstraintLayoutActivity.java`**

        -   These 2 activities use the same purpose and code as the `MainActivity.java` activity, it is simply to separate the different `Layouts`.

-   ### **XML files** (Application Frontend):

    _Depending on the resolution of the device and whether it is oriented Portrait or Landscape, one of the Layouts will be activated. (`vertical`, `land`, `xlarge`, `xlarge-land`)_

    -   **`activity_main.xml`** (`vertical`, `land`, `xlarge`, `xlarge-land`)

        -   Inside a `LinearLayout` tag, we will insert 2 `Button` tags and 1 `TextView` tag, to display the counter value, add +1 to the counter, and display the counter value via a `Toast`.

    -   **`activity_relative_layout.xml`** (`vertical`, `land`, `xlarge`, `xlarge-land`)

        -   Inside a `RelativeLayout` tag, we will insert 2 `Button` tags and 1 `TextView` tag, to display the counter value, add +1 to the counter, and display the counter value via a `Toast`.

        -   The elements will be linked together to achieve the relative View that the `RelativeLayout` tags allow us.

    -   **`activity_constraint_layout.xml`** (`vertical`, `land`, `xlarge`, `xlarge-land`)

        -   Inside a `ConstraintLayout` tag, we will insert 2 `Button` tags and 1 `TextView` tag, to display the counter value, add +1 to the counter, and display the counter value via a `Toast`.

        -   In this case, the elements will be relinked to each other, as well as benefiting from the different attributes that can be applied when using `ConstraintLayout`.

## **Code**

<ul>

### <li>**Java files**

<ul>

<li>

<details>

**<summary>`MainActivity.java`</summary>**

```java
package com.example.task12b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonToast;
    private Button buttonCount;
    private TextView showCount;
    private Button goToRelativeLayout;
    private Button goToConstraintLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.buttonToast = findViewById(R.id.button_toast);
        this.buttonCount = findViewById(R.id.button_count);
        this.showCount = findViewById(R.id.show_count);
        this.goToRelativeLayout = findViewById(R.id.goToRelativeLayout);
        this.goToConstraintLayout = findViewById(R.id.goToConstraintLayout);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.showCount.setText(extras.getString("count"));
        }

        if (savedInstanceState != null) {
            this.showCount.setText(savedInstanceState.getString("numberCount"));
        }




        this.buttonCount.setOnClickListener(view ->
                this.sumCount()
        );

        this.buttonToast.setOnClickListener(view ->
                this.showToastCount()
        );

        this.goToRelativeLayout.setOnClickListener(view -> {
            Intent intent = new Intent(this, RelativeLayoutActivity.class);
            intent.putExtra("count", this.showCount.getText());
            this.startActivity(intent);
        });

        this.goToConstraintLayout.setOnClickListener(view -> {
            Intent intent = new Intent(this, ConstraintLayoutActivity.class);
            intent.putExtra("count", this.showCount.getText());
            this.startActivity(intent);
        });
    }

    public void sumCount() {
        int sum = Integer.parseInt((String) this.showCount.getText()) + 1;
        this.showCount.setText(String.valueOf(sum));

    }


    public void showToastCount() {
        Toast.makeText(this, showCount.getText(), Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("numberCount", (String) this.showCount.getText());

    }


}
```

</details>

</li>

<li>

<details>

**<summary>`RelativeLayoutActivity.java`</summary>**

```java
package com.example.task12b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RelativeLayoutActivity extends AppCompatActivity {

    private Button buttonToast;
    private Button buttonCount;
    private TextView showCount;
    private Button goToLinearLayout;
    private Button goToConstraintLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);


        this.buttonToast = findViewById(R.id.button_toast);
        this.buttonCount = findViewById(R.id.button_count);
        this.showCount = findViewById(R.id.show_count);
        this.goToLinearLayout = findViewById(R.id.goToLinearLayout);
        this.goToConstraintLayout = findViewById(R.id.goToConstraintLayout);



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.showCount.setText(extras.getString("count"));
        }

        if (savedInstanceState != null) {
            this.showCount.setText(savedInstanceState.getString("numberCount"));
        }



        this.buttonCount.setOnClickListener(view ->
                this.sumCount()
        );

        this.buttonToast.setOnClickListener(view ->
                this.showToastCount()
        );

        this.goToLinearLayout.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("count", this.showCount.getText());
            this.startActivity(intent);
        });

        this.goToConstraintLayout.setOnClickListener(view -> {
            Intent intent = new Intent(this, ConstraintLayoutActivity.class);
            intent.putExtra("count", this.showCount.getText());
            this.startActivity(intent);
        });

    }

    public void sumCount() {
        int sum = Integer.parseInt((String) this.showCount.getText()) + 1;
        this.showCount.setText(String.valueOf(sum));

    }


    public void showToastCount() {
        Toast.makeText(this, showCount.getText(), Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("numberCount", (String) this.showCount.getText());

    }
}
```

</details>

</li>

<li>

<details>

**<summary>`ConstraintLayoutActivity.java`</summary>**

```java
package com.example.task12b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ConstraintLayoutActivity extends AppCompatActivity {

    private Button buttonToast;
    private Button buttonCount;
    private TextView showCount;
    private Button goToLinearLayout;
    private Button goToRelativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);


        this.buttonToast = findViewById(R.id.button_toast);
        this.buttonCount = findViewById(R.id.button_count);
        this.showCount = findViewById(R.id.show_count);
        this.goToLinearLayout = findViewById(R.id.goToLinearLayout);
        this.goToRelativeLayout = findViewById(R.id.goToRelativeLayout);



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.showCount.setText(extras.getString("count"));
        }

        if (savedInstanceState != null) {
            this.showCount.setText(savedInstanceState.getString("numberCount"));
        }



        this.buttonCount.setOnClickListener(view ->
                this.sumCount()
        );

        this.buttonToast.setOnClickListener(view ->
                this.showToastCount()
        );

        this.goToLinearLayout.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("count", this.showCount.getText());
            this.startActivity(intent);
        });

        this.goToRelativeLayout.setOnClickListener(view -> {
            Intent intent = new Intent(this, RelativeLayoutActivity.class);
            intent.putExtra("count", this.showCount.getText());
            this.startActivity(intent);
        });

    }

    public void sumCount() {
        int sum = Integer.parseInt((String) this.showCount.getText()) + 1;
        this.showCount.setText(String.valueOf(sum));

    }


    public void showToastCount() {
        Toast.makeText(this, showCount.getText(), Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("numberCount", (String) this.showCount.getText());

    }
}
```

</details>

</li>

</ul>

</li>

### <li>**XML files**

<ul>

#### <li>**`activity_main.xml`**

<ul>

<li>

<details>

**<summary>(vertical)</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="20sp"
    android:gravity="center"
    android:orientation="vertical">


    <Button
        android:id="@+id/button_toast"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:height="60sp"
        android:text="Toast" />

    <TextView
        android:id="@+id/show_count"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:height="300sp"
        android:background="@color/yellow"
        android:gravity="center"
        android:text="0"
        android:textColor="@color/purple_500"
        android:textSize="150sp"
        android:textStyle="bold" />


    <Button
        android:id="@+id/button_count"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:height="60sp"
        android:text="Count" />


    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">

        <Button
            android:id="@+id/goToRelativeLayout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginEnd="5dp"
            android:text="Relative Layout"
            android:textSize="13dp" />

        <Button
            android:id="@+id/goToConstraintLayout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Constraint Layout"
            android:textSize="13dp" />

    </LinearLayout>

</LinearLayout>
```

</details>

</li>

<li>

<details>

**<summary>(land)</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="20sp"
    android:gravity="center"
    android:orientation="vertical">


    <Button
        android:id="@+id/button_toast"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:height="40sp"
        android:text="Toast" />

    <TextView
        android:id="@+id/show_count"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:height="90sp"
        android:background="@color/yellow"
        android:gravity="center"
        android:text="0"
        android:textColor="@color/purple_500"
        android:textSize="70sp"
        android:textStyle="bold" />


    <Button
        android:id="@+id/button_count"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:height="40sp"
        android:text="Count" />


    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <Button
            android:id="@+id/goToRelativeLayout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginEnd="5dp"
            android:text="Relative Layout" />

        <Button
            android:id="@+id/goToConstraintLayout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Constraint Layout" />

    </LinearLayout>


</LinearLayout>
```

</details>

</li>

<li>

<details>

**<summary>(xlarge)</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="20sp"
    android:gravity="center"
    android:orientation="vertical">


    <Button
        android:id="@+id/button_toast"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="80sp"
        android:text="Toast" />

    <TextView
        android:id="@+id/show_count"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:height="670sp"
        android:background="@color/yellow"
        android:gravity="center"
        android:text="0"
        android:textColor="@color/purple_500"
        android:textSize="200sp"
        android:textStyle="bold" />


    <Button
        android:id="@+id/button_count"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="80sp"
        android:text="Count" />


    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">

        <Button
            android:id="@+id/goToRelativeLayout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginEnd="5dp"
            android:text="Relative Layout"
            android:textSize="40sp" />

        <Button
            android:id="@+id/goToConstraintLayout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Constraint Layout"
            android:textSize="40sp" />

    </LinearLayout>

</LinearLayout>
```

</details>

</li>

<li>

<details>

**<summary>(xlarge-land)</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="20sp"
    android:gravity="center"
    android:orientation="vertical">


    <Button
        android:id="@+id/button_toast"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="60sp"
        android:text="Toast" />

    <TextView
        android:id="@+id/show_count"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:height="260sp"
        android:background="@color/yellow"
        android:gravity="center"
        android:text="0"
        android:textColor="@color/purple_500"
        android:textSize="160sp"
        android:textStyle="bold" />


    <Button
        android:id="@+id/button_count"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="60sp"
        android:text="Count" />


    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">

        <Button
            android:id="@+id/goToRelativeLayout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginEnd="5dp"
            android:text="Relative Layout"
            android:textSize="40sp" />

        <Button
            android:id="@+id/goToConstraintLayout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Constraint Layout"
            android:textSize="40sp" />

    </LinearLayout>

</LinearLayout>
```

</details>

</li>

</ul>

</li>

#### <li>**`activity_relative_layout.xml`**

<ul>

<li>

<details>

**<summary>(vertical)</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="40sp"
    android:gravity="fill_vertical">


    <Button
        android:id="@+id/button_toast"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:height="60sp"
        android:text="Toast" />


    <TextView
        android:id="@+id/show_count"
        android:layout_width="226dp"
        android:layout_height="213dp"
        android:layout_toEndOf="@+id/button_toast"
        android:height="200sp"
        android:background="@color/yellow"
        android:text="0"
        android:textColor="@color/purple_500"
        android:textSize="150sp"
        android:textStyle="bold" />

    <Button
        android:id="@+id/button_count"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/button_toast"
        android:height="60sp"
        android:text="Count" />

    <Button
        android:id="@+id/goToLinearLayout"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/show_count"
        android:layout_marginStart="-246dp"
        android:layout_marginTop="69dp"
        android:layout_toEndOf="@+id/show_count"
        android:text="Linear Layout" />

    <Button
        android:id="@+id/goToConstraintLayout"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/goToLinearLayout"
        android:layout_alignParentEnd="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="3dp"
        android:layout_marginEnd="65dp"
        android:text="Constraint Layout" />

</RelativeLayout>

```

</details>

</li>

<li>

<details>

**<summary>(land)</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="40sp"
    android:gravity="fill_vertical">


    <Button
        android:id="@+id/button_toast"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:height="60sp"
        android:text="Toast" />


    <TextView
        android:id="@+id/show_count"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_toEndOf="@+id/button_toast"
        android:height="200sp"
        android:background="@color/yellow"
        android:text="0"
        android:textColor="@color/purple_500"
        android:textSize="150sp"
        android:textStyle="bold" />

    <Button
        android:id="@+id/button_count"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/button_toast"
        android:height="60sp"
        android:text="Count" />

    <Button
        android:id="@+id/goToLinearLayout"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_marginStart="30dp"
        android:layout_marginTop="41dp"
        android:layout_toEndOf="@+id/show_count"
        android:text="Linear Layout" />

    <Button
        android:id="@+id/goToConstraintLayout"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/goToLinearLayout"
        android:layout_marginStart="11dp"
        android:layout_marginTop="23dp"
        android:layout_toEndOf="@+id/show_count"
        android:text="Constraint Layout" />

</RelativeLayout>

```

</details>

</li>

<li>

<details>

**<summary>(xlarge)</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="40sp"
    android:gravity="fill_vertical">


    <Button
        android:id="@+id/button_toast"
        android:layout_width="431dp"
        android:layout_height="247dp"
        android:layout_alignParentStart="true"
        android:layout_alignParentTop="true"
        android:layout_marginStart="117dp"
        android:layout_marginTop="33dp"
        android:text="Toast"
        android:textSize="100sp" />

    <TextView
        android:id="@+id/show_count"
        android:layout_width="682dp"
        android:layout_height="358dp"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginStart="-529dp"
        android:layout_marginTop="309dp"
        android:layout_toEndOf="@+id/button_toast"
        android:height="200sp"
        android:background="@color/yellow"
        android:text="0"
        android:gravity="center"
        android:textColor="@color/purple_500"
        android:textSize="250sp"
        android:textStyle="bold" />

    <Button
        android:id="@+id/button_count"
        android:layout_width="460dp"
        android:layout_height="208dp"
        android:layout_below="@+id/button_toast"
        android:layout_alignParentEnd="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="407dp"
        android:layout_marginEnd="129dp"
        android:text="Count"
        android:textSize="100sp" />

    <Button
        android:id="@+id/goToLinearLayout"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/show_count"
        android:layout_alignParentStart="true"
        android:layout_marginStart="6dp"
        android:layout_marginTop="254dp"
        android:layout_toEndOf="@+id/show_count"
        android:text="Linear Layout"
        android:textSize="40sp" />

    <Button
        android:id="@+id/goToConstraintLayout"
        android:layout_width="355dp"
        android:layout_height="wrap_content"
        android:layout_below="@+id/goToLinearLayout"
        android:layout_alignParentEnd="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="-122dp"
        android:layout_marginEnd="20dp"
        android:text="Constraint Layout"
        android:textSize="40sp" />

</RelativeLayout>

```

</details>

</li>

<li>

<details>

**<summary>(xlarge-land)</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="40sp"
    android:gravity="fill_vertical">


    <Button
        android:id="@+id/button_toast"
        android:layout_width="405dp"
        android:layout_height="206dp"
        android:layout_alignParentStart="true"
        android:layout_alignParentTop="true"
        android:layout_marginStart="17dp"
        android:layout_marginTop="6dp"
        android:text="Toast"
        android:textSize="100sp" />

    <TextView
        android:id="@+id/show_count"
        android:layout_width="682dp"
        android:layout_height="358dp"
        android:layout_alignParentStart="true"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginStart="19dp"
        android:layout_marginTop="218dp"
        android:layout_toEndOf="@+id/button_toast"
        android:height="200sp"
        android:background="@color/yellow"
        android:gravity="center"
        android:text="0"
        android:textColor="@color/purple_500"
        android:textSize="250sp"
        android:textStyle="bold" />

    <Button
        android:id="@+id/button_count"
        android:layout_width="408dp"
        android:layout_height="199dp"
        android:layout_below="@+id/button_toast"
        android:layout_alignParentTop="true"
        android:layout_alignParentEnd="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="12dp"
        android:layout_marginEnd="360dp"
        android:text="Count"
        android:textSize="100sp" />

    <Button
        android:id="@+id/goToLinearLayout"
        android:layout_width="446dp"
        android:layout_height="173dp"
        android:layout_below="@+id/show_count"
        android:layout_alignParentStart="true"
        android:layout_centerVertical="true"
        android:layout_marginStart="719dp"
        android:layout_marginTop="-358dp"
        android:layout_toEndOf="@+id/show_count"
        android:text="Linear Layout"
        android:textSize="50sp" />

    <Button
        android:id="@+id/goToConstraintLayout"
        android:layout_width="441dp"
        android:layout_height="157dp"
        android:layout_below="@+id/goToLinearLayout"
        android:layout_alignParentEnd="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="30dp"
        android:layout_marginEnd="37dp"
        android:text="Constraint Layout"
        android:textSize="50sp" />

</RelativeLayout>

```

</details>

</li>

</ul>

</li>

#### <li>**`activity_constraint_layout.xml`**

<ul>

<li>

<details>

**<summary>(vertical)</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/ConstraintLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="20sp"
    android:gravity="center">


    <Button
        android:id="@+id/button_toast"
        android:layout_width="89dp"
        android:layout_height="49dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        android:height="60sp"
        android:text="Toast"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/show_count"
        android:layout_width="245dp"
        android:layout_height="316dp"
        android:layout_marginStart="20dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="120dp"
        android:height="300sp"
        android:background="@color/yellow"
        android:gravity="center"
        android:text="0"
        android:textColor="@color/purple_500"
        android:textSize="150sp"
        android:textStyle="bold"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toEndOf="@+id/button_count"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button_count"
        android:layout_width="89dp"
        android:layout_height="49dp"
        android:layout_marginStart="16dp"
        android:height="60sp"
        android:text="Count"
        app:layout_constraintBaseline_toBaselineOf="@+id/show_count"
        app:layout_constraintStart_toStartOf="parent" />


    <Button
        android:id="@+id/goToLinearLayout"
        android:layout_width="161dp"
        android:layout_height="52dp"
        android:layout_marginStart="132dp"
        android:layout_marginTop="20dp"
        android:text="Linear Layout"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/show_count" />

    <Button
        android:id="@+id/goToRelativeLayout"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="132dp"
        android:layout_marginTop="4dp"
        android:text="Relative Layout"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/goToLinearLayout" />


</androidx.constraintlayout.widget.ConstraintLayout>
```

</details>

</li>

<li>

<details>

**<summary>(land)</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/ConstraintLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="20sp"
    android:gravity="center">


    <Button
        android:id="@+id/button_toast"
        android:layout_width="89dp"
        android:layout_height="49dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="165dp"
        android:height="60sp"
        android:text="Toast"
        app:layout_constraintBottom_toTopOf="@+id/button_count"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/show_count"
        android:layout_width="321dp"
        android:layout_height="322dp"
        android:layout_marginStart="20dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="120dp"
        android:height="300sp"
        android:background="@color/yellow"
        android:gravity="center"
        android:text="0"
        android:textColor="@color/purple_500"
        android:textSize="150sp"
        android:textStyle="bold"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toEndOf="@+id/button_count"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button_count"
        android:layout_width="89dp"
        android:layout_height="49dp"
        android:layout_marginStart="16dp"
        android:height="60sp"
        android:text="Count"
        app:layout_constraintBaseline_toBaselineOf="@+id/show_count"
        app:layout_constraintStart_toStartOf="parent" />


    <Button
        android:id="@+id/goToLinearLayout"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Linear Layout"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.537"
        app:layout_constraintStart_toEndOf="@+id/show_count"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.229" />

    <Button
        android:id="@+id/goToRelativeLayout"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="28dp"
        android:layout_marginEnd="32dp"
        android:text="Relative Layout"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/goToLinearLayout" />


</androidx.constraintlayout.widget.ConstraintLayout>
```

</details>

</li>

<li>

<details>

**<summary>(xlarge)</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/ConstraintLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="20sp"
    android:gravity="center">


    <Button
        android:id="@+id/button_toast"
        android:layout_width="566dp"
        android:layout_height="154dp"
        android:layout_marginStart="96dp"
        android:layout_marginTop="40dp"
        android:text="Toast"
        android:textSize="120sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/show_count"
        android:layout_width="630dp"
        android:layout_height="329dp"
        android:layout_marginTop="28dp"
        android:layout_marginEnd="64dp"
        android:height="300sp"
        android:background="@color/yellow"
        android:gravity="center"
        android:text="0"
        android:textColor="@color/purple_500"
        android:textSize="250sp"
        android:textStyle="bold"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button_toast" />

    <Button
        android:id="@+id/button_count"
        android:layout_width="513dp"
        android:layout_height="214dp"
        android:layout_marginTop="20dp"
        android:text="Count"
        android:textSize="120sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.502"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/show_count" />

    <Button
        android:id="@+id/goToLinearLayout"
        android:layout_width="298dp"
        android:layout_height="243dp"
        android:layout_marginStart="52dp"
        android:layout_marginTop="40dp"
        android:text="Linear Layout"
        android:textSize="50sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button_count" />

    <Button
        android:id="@+id/goToRelativeLayout"
        android:layout_width="323dp"
        android:layout_height="240dp"
        android:layout_marginStart="36dp"
        android:layout_marginTop="40dp"
        android:text="Relative Layout"
        android:textSize="50sp"
        app:layout_constraintStart_toEndOf="@+id/goToLinearLayout"
        app:layout_constraintTop_toBottomOf="@+id/button_count" />


</androidx.constraintlayout.widget.ConstraintLayout>
```

</details>

</li>

<li>

<details>

**<summary>(xlarge-land)</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/ConstraintLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="20sp"
    android:gravity="center">


    <Button
        android:id="@+id/button_toast"
        android:layout_width="531dp"
        android:layout_height="128dp"
        android:layout_marginStart="4dp"
        android:layout_marginTop="4dp"
        android:text="Toast"
        android:textSize="80sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/show_count"
        android:layout_width="652dp"
        android:layout_height="334dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="8dp"
        android:background="@color/yellow"
        android:gravity="center"
        android:text="0"
        android:textColor="@color/purple_500"
        android:textSize="250sp"
        android:textStyle="bold"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button_count" />

    <Button
        android:id="@+id/button_count"
        android:layout_width="528dp"
        android:layout_height="131dp"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:text="Count"
        android:textSize="80sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button_toast" />

    <Button
        android:id="@+id/goToLinearLayout"
        android:layout_width="671dp"
        android:layout_height="216dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="16dp"
        android:text="Linear Layout"
        android:textSize="80sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/goToRelativeLayout"
        android:layout_width="548dp"
        android:layout_height="297dp"
        android:layout_marginTop="4dp"
        android:layout_marginEnd="16dp"
        android:text="Relative Layout"
        android:textSize="80sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/goToLinearLayout" />


</androidx.constraintlayout.widget.ConstraintLayout>
```

</details>

</li>

</ul>

</li>

</ul>

</li>

</ul>
