/**
 *
 * Copyright 2019 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.demotabbing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        /* create an instance of the tab layout from the view */
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        /* set the text for each dynamic tabs */
        tabLayout.addTab(tabLayout.newTab().setText(R.string.dynamic_tab_one))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.dynamic_tab_two))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.dynamic_tab_three))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.dynamic_tab_four))
        /* set the tabs to fill the entire layout */
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        /* manage page views in fragments */
        val viewPager = findViewById<ViewPager>(R.id.pager)
        val pagerAdapter = SpecificPagerAdapter(supportFragmentManager, tabLayout.tabCount)
        /* setting a listener for clicks */
        viewPager.adapter = pagerAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    viewPager.currentItem = tab.position
                }
                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })
    }
}
