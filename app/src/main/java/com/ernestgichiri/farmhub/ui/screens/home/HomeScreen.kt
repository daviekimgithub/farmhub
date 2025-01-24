package com.ernestgichiri.farmhub.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ernestgichiri.farmhub.R
import com.ernestgichiri.farmhub.common.ScreenState
import com.ernestgichiri.farmhub.ui.Error
import com.ernestgichiri.farmhub.ui.Loading
import com.ernestgichiri.farmhub.ui.theme.AppTheme
import com.ernestgichiri.farmhub.ui.uiData.ProductUiData

@Composable
fun HomeRoute(
    onProductClicked: (ProductUiData) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val productState by viewModel.products.observeAsState(initial = ScreenState.Loading)
    val categoryState by viewModel.categories.observeAsState(initial = ScreenState.Loading)
    val onCategoryClicked = { category: String ->
        viewModel.getProductsByCategory(category)
    }
    var searchQuery by remember { mutableStateOf("") }
    val onSearchTextChanged: (String) -> Unit = { newSearchQuery ->
        searchQuery = newSearchQuery
        if (newSearchQuery.isNotEmpty()) {
            viewModel.searchProduct(newSearchQuery)
        }
    }
    HomeScreen(
        productState = productState,
        categoryState = categoryState,
        onProductClicked = onProductClicked,
        onCategoryClicked = onCategoryClicked,
        onSearchTextChanged = onSearchTextChanged,
        searchQuery = searchQuery,
    )
}

@Composable
fun HomeScreen(
    productState: ScreenState<List<ProductUiData>>?,
    categoryState: ScreenState<List<String>>,
    onProductClicked: (ProductUiData) -> Unit,
    onCategoryClicked: (String) -> Unit,
    onSearchTextChanged: (String) -> Unit,
    searchQuery: String,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            productState is ScreenState.Success && categoryState is ScreenState.Success -> {
                SuccessScreen(
                    productUiData = productState.uiData,
                    categoryUiData = categoryState.uiData,
                    onCategoryClicked = onCategoryClicked,
                    onProductClicked = onProductClicked,
                    onSearchTextChanged = onSearchTextChanged,
                    searchQuery = searchQuery,
                )
            }

            productState is ScreenState.Error || categoryState is ScreenState.Error -> {
                Error(message = "Error")
            }

            productState is ScreenState.Loading || categoryState is ScreenState.Loading -> {
                Loading()
            }

            else -> {
                Error(message = "Error")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuccessScreen(
    modifier: Modifier = Modifier,
    productUiData: List<ProductUiData>,
    categoryUiData: List<String>,
    onProductClicked: (ProductUiData) -> Unit = {},
    onCategoryClicked: (String) -> Unit,
    onSearchTextChanged: (String) -> Unit,
    searchQuery: String,
) {
    var active by remember { mutableStateOf(false) }
    var searchQueryState = searchQuery
    Column(modifier = modifier) {
        ProductList(
            products = productUiData,
            onProductClicked = onProductClicked,
        )
    }
}

@Preview
@Composable
fun LoadingItemPreview() {
    AppTheme {
        Loading()
    }
}

@Preview
@Composable
fun ErrorPreview() {
    AppTheme {
        Box {
            Error("Unexpected Error")
        }
    }
}
