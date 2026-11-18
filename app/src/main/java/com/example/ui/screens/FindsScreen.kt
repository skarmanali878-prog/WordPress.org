package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.data.FindCategory
import com.example.data.HerFindsConstants
import com.example.ui.HerFindsUiState
import com.example.ui.components.AmazonWishlistBannerCard
import com.example.ui.components.ProductFindCard
import com.example.ui.components.copyTextToClipboard
import com.example.ui.components.openExternalUrl

@Composable
fun FindsScreen(
    uiState: HerFindsUiState,
    onCategorySelected: (FindCategory?) -> Unit,
    onSearchQueryChange: (String) -> Unit,
    onToggleSavedOnly: () -> Unit,
    onClearFilters: () -> Unit,
    onFindClick: (String) -> Unit,
    onToggleSave: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val finds = uiState.filteredFinds

    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val columns = if (maxWidth >= 660.dp) 2 else 1
        val chunkedFinds = finds.chunked(columns)

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Column {
                    SectionEyebrowHeader(
                        eyebrow = "CURATED CATALOG",
                        title = "Shop All Finds",
                        subtitle = HerFindsConstants.AFFILIATE_DISCLOSURE_SHORT
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    OutlinedTextField(
                        value = uiState.searchQuery,
                        onValueChange = onSearchQueryChange,
                        placeholder = { Text("Search fashion, beauty, home, kitchen...") },
                        leadingIcon = {
                            Icon(Icons.Outlined.Search, contentDescription = null)
                        },
                        trailingIcon = {
                            if (uiState.searchQuery.isNotEmpty()) {
                                IconButton(
                                    onClick = { onSearchQueryChange("") },
                                    modifier = Modifier.minimumInteractiveComponentSize()
                                ) {
                                    Icon(Icons.Outlined.Clear, contentDescription = "Clear search")
                                }
                            }
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(50),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = MaterialTheme.colorScheme.surface,
                            unfocusedContainerColor = MaterialTheme.colorScheme.surface
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("finds_search_input")
                    )
                }
            }

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    item {
                        FilterChip(
                            selected = uiState.selectedCategory == null && !uiState.showSavedOnlyInCatalog,
                            onClick = {
                                onCategorySelected(null)
                                if (uiState.showSavedOnlyInCatalog) onToggleSavedOnly()
                            },
                            label = { Text("All (${uiState.allFinds.size})") },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.primary,
                                selectedLabelColor = Color.White
                            ),
                            modifier = Modifier.testTag("filter_chip_all")
                        )
                    }
                    item {
                        FilterChip(
                            selected = uiState.showSavedOnlyInCatalog,
                            onClick = onToggleSavedOnly,
                            leadingIcon = {
                                Icon(
                                    imageVector = if (uiState.showSavedOnlyInCatalog) {
                                        Icons.Filled.Bookmark
                                    } else {
                                        Icons.Outlined.BookmarkBorder
                                    },
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp)
                                )
                            },
                            label = { Text("Saved (${uiState.savedFindIds.size})") },
                            modifier = Modifier.testTag("filter_chip_saved")
                        )
                    }
                    items(FindCategory.entries) { category ->
                        FilterChip(
                            selected = uiState.selectedCategory == category,
                            onClick = {
                                onCategorySelected(
                                    if (uiState.selectedCategory == category) null else category
                                )
                            },
                            label = { Text(category.shortTitle) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.primary,
                                selectedLabelColor = Color.White
                            ),
                            modifier = Modifier.testTag("filter_chip_${category.name.lowercase()}")
                        )
                    }
                }
            }

            item {
                AmazonWishlistBannerCard(
                    onOpenWishlist = {
                        openExternalUrl(context, HerFindsConstants.CURATED_AMAZON_WISHLIST_URL)
                    },
                    onCopyLink = {
                        copyTextToClipboard(
                            context,
                            "HerFinds Amazon Wishlist",
                            HerFindsConstants.CURATED_AMAZON_WISHLIST_URL
                        )
                    }
                )
            }

            if (finds.isEmpty()) {
                item {
                    Surface(
                        color = MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(22.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(28.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.ShoppingBag,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(44.dp)
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = "No matching finds",
                                style = MaterialTheme.typography.headlineSmall,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "Try clearing your search or switching categories to explore all curated picks.",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(
                                onClick = onClearFilters,
                                shape = RoundedCornerShape(50),
                                modifier = Modifier.minimumInteractiveComponentSize()
                            ) {
                                Text("Reset Filters")
                            }
                        }
                    }
                }
            } else {
                items(chunkedFinds) { rowItems ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        rowItems.forEach { find ->
                            ProductFindCard(
                                find = find,
                                isSaved = find.id in uiState.savedFindIds,
                                onToggleSave = { onToggleSave(find.id) },
                                onCardClick = { onFindClick(find.id) },
                                onViewOnAmazon = { openExternalUrl(context, find.amazonUrl) },
                                modifier = Modifier.weight(1f)
                            )
                        }
                        if (rowItems.size < columns) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}
