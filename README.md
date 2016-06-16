# Hexagon-Recyclerview

This is a recyclerview where items are interpolated in a way that looks like a honeycomb. It can be customized to be vertically  or horizontally scrollable. 



Vertical                   |  Horizontal 
:-------------------------:|:-------------------------:
![](http://s33.postimg.org/hfvuws0a7/device_2016_06_07_154927.png)  |  ![](http://s33.postimg.org/vnfklk8rz/device_2016_06_07_153715.png)



Download
--------

Download via Gradle:
- Add the following to the project's build.gralde
```groovy
allprojects {
    repositories {
       jcenter()
    }
}
```
- Add this to your dependencies
```groovy
compile 'com.mindvalley.android:hexagonrecyclerview:1.0.1'
```





Usage
--------

The Hexagon-Recyclerview is a child of the default Recyclerview, which makes using the Hexagon-Recyclerview exactly similar to using the default recyclerview.

- Add the Hexagon-Recyclerview to the xml layout file

```groovy
<com.abed.hexagonrecyclerview.view.HexagonRecyclerView xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/rvItems"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_alignParentLeft="true"
        android:layout_centerVertical="true"
        app:items_count_in_row="3"
        app:items_horizontal_spacing="20dp"
        app:items_vertical_spacing="20dp"
        app:orientation="horizontal" />
```
- The Hexagon-Recyclerview has 4 paramters to specify: 
  - items_count_in_row: a number that is more than 2. It specifies the number of the items in the big row of the Hexagon-Recyclerview
  - items_horizontal_spacing: (optional. Default 0dp) It specifies the dimension of the horizontal spacing between the items.
  - items_vertical_spacing: (optional. Default 0dp) It specifies the dimension of the vertical spacing between the items.
  - orientation: has two values horizontal/vertical. If not specified then the default value is horizontal.
  

###### The recyclerview item: 
The layout of the item inside the Hexagon-Recyclerview (Which will be used inside the adapter) can be anything.

In case you want to show hexagon imagewviews then you write the following in the xml layout file of the item:

- For horizontal Recyclerview:
```groovy
<com.abed.hexagonrecyclerview.view.HorizontallyAdaptableHexagonImageView xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/img_view"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
     />
```
- For vertical Recyclerview:
```groovy
<com.abed.hexagonrecyclerview.view.VerticallyAdaptableHexagonImageView xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/img_view"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
     />
```





Example:
--------


Vertical                   |  Horizontal 
:-------------------------:|:-------------------------:
 ![alt tag](http://s33.postimg.org/afp9wo9y7/ezgif_com_resize_1.gif) | ![](http://s33.postimg.org/n7fsyqwkf/ezgif_com_resize.gif) 




My Contact:
--------
If you have any comment or question don't hesitate to contact me.

my email: abd.almoradi@gmail.com

Thank you.




License
--------

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

