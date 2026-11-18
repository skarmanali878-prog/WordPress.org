package com.example.data

enum class FindCategory(
    val title: String,
    val shortTitle: String,
    val subtitle: String,
    val badgeLabel: String
) {
    FASHION(
        title = "Fashion Finds",
        shortTitle = "Fashion",
        subtitle = "Everyday layers, structured totes, and effortless wardrobe staples",
        badgeLabel = "FASHION"
    ),
    BEAUTY(
        title = "Beauty Favorites",
        shortTitle = "Beauty",
        subtitle = "Gentle glow serums, lip tints, and thoughtful vanity essentials",
        badgeLabel = "BEAUTY"
    ),
    HOME(
        title = "Home Essentials",
        shortTitle = "Home Finds",
        subtitle = "Warm textures, ambient lighting, and calm living accents",
        badgeLabel = "HOME"
    ),
    KITCHEN(
        title = "Kitchen Finds",
        shortTitle = "Kitchen",
        subtitle = "Clever prep tools, morning coffee rituals, and countertop gems",
        badgeLabel = "KITCHEN"
    ),
    ORGANIZATION(
        title = "Organization",
        shortTitle = "Organization",
        subtitle = "Modular bins, travel pouches, and clutter-free closet systems",
        badgeLabel = "ORGANIZATION"
    ),
    LIFESTYLE(
        title = "Lifestyle Picks",
        shortTitle = "Lifestyle",
        subtitle = "Daily hydration, desk upgrades, and intentional weekend favorites",
        badgeLabel = "LIFESTYLE"
    )
}

enum class ProductVisualType {
    TOTE_BAG,
    CARDIGAN,
    SILK_SCARF,
    SUNGLASSES,
    GLOW_SERUM,
    BRUSH_SET,
    CLAW_CLIPS,
    THROW_BLANKET,
    CERAMIC_VASE,
    AMBER_LAMP,
    ELECTRIC_KETTLE,
    GLASS_MUGS,
    PANTRY_JARS,
    DRAWER_ORGANIZER,
    TRAVEL_POUCH,
    TUMBLER,
    LINEN_JOURNAL,
    DESK_STAND
}

data class CuratedFind(
    val id: String,
    val title: String,
    val category: FindCategory,
    val shortDescription: String,
    val editorialNote: String,
    val priceNote: String,
    val highlightTag: String,
    val amazonUrl: String,
    val highlights: List<String>,
    val isTrending: Boolean = false,
    val visualType: ProductVisualType
)

data class GuideSection(
    val heading: String,
    val body: String
)

data class ShoppingGuide(
    val id: String,
    val title: String,
    val subtitle: String,
    val category: FindCategory,
    val readTimeMinutes: Int,
    val intro: String,
    val sections: List<GuideSection>,
    val featuredFindIds: List<String>
)

data class BlogArticle(
    val id: String,
    val categoryLabel: String,
    val title: String,
    val excerpt: String,
    val readTimeMinutes: Int,
    val publishedLabel: String,
    val bodyParagraphs: List<String>,
    val relatedFindIds: List<String>
)

data class CustomWishlistLink(
    val id: String,
    val title: String,
    val url: String,
    val note: String
)

object HerFindsConstants {
    const val CURATED_AMAZON_WISHLIST_URL =
        "https://www.amazon.com/hz/wishlist/dl/invite/AQICAHild4Vpadjqcz7bdgUf6Qu6-OaRt7P_FJRNNbyMlg-OQwEhIKvfa_ctBmm5Wo4c1ygAAAAAkTCBjgYJKoZIhvcNAQcGoIGAMH4CAQAweQYJKoZIhvcNAQcBMB4GCWCGSAFlAwQBLjARBAzqnta1ascHFs0uOQYCARCATE6vuyr9nyOe6ndFcHgb-MQGFJLog-tPMSUAMDhD7n1HizvQ4iXX_CvTQ672Z8TodSkIkJPEMOq75-HEGlUAfI67ZoWeAaNb1HHEdB0?ref_=wl_share"

    const val ANNOUNCEMENT_TEXT = "Discover your next favorite find!"
    const val AFFILIATE_DISCLOSURE_SHORT = "As an Amazon Associate I earn from qualifying purchases."
    const val AFFILIATE_DISCLOSURE_FULL =
        "Some links featured in HerFinds are Amazon affiliate links. As an Amazon Associate I earn from qualifying purchases at no additional cost to you. Product availability and pricing are determined directly by Amazon and may change at any time. HerFinds is an independent editorial curation app and is not endorsed by or affiliated with Amazon.com, Inc."
    const val CHLOE_FULL_BIO =
        "Chloe Bennett is our fictional AI brand ambassador who helps introduce useful finds, shopping inspiration, and lifestyle ideas across fashion, beauty, home, and everyday organization.\n\nTransparency notice: Chloe Bennett is an AI-generated character. She has not personally tested, owned, or reviewed any product featured on HerFinds. Editorial selections are curated for inspiration and direct convenience to Amazon."
    const val PRIVACY_SUMMARY =
        "HerFinds stores your saved finds, custom wishlist links, and optional newsletter preference locally on your device. If you tap 'View on Amazon' or open the shared Amazon Wishlist, you will leave the app and open Amazon in your browser under Amazon's own privacy and terms policies."
    const val TERMS_SUMMARY =
        "All editorial guides, articles, and product notes are provided for general shopping inspiration. Always verify product specifications, ingredients, sizing, and current pricing on the official Amazon product page before purchasing."
    const val CONTACT_INFO =
        "Editorial & Partnership Inquiries: hello@herfinds.example\nBrand Ambassador: Chloe Bennett (Fictional AI Character)\nCurated Wishlist: Shared Amazon Wishlist Invite"
}
