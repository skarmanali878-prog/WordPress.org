package com.example.data

object HerFindsCatalog {

    val curatedFinds: List<CuratedFind> = listOf(
        // Fashion Finds
        CuratedFind(
            id = "find_structured_tote",
            title = "Structured Vegan Leather Work Tote",
            category = FindCategory.FASHION,
            shortDescription = "Sleek everyday carryall with a padded laptop sleeve and warm gold-tone hardware.",
            editorialNote = "Designed to transition smoothly from morning commute to coffee catch-ups, this structured silhouette keeps notebooks, chargers, and essentials upright without losing its shape.",
            priceNote = "Under $45 on Amazon",
            highlightTag = "Trending Pick",
            amazonUrl = "https://www.amazon.com/s?k=structured+vegan+leather+work+tote+bag",
            highlights = listOf(
                "Fits up to 15.6-inch laptops with padded divider",
                "Structured flat base stands upright on desks",
                "Water-resistant pebbled finish wipes clean easily"
            ),
            isTrending = true,
            visualType = ProductVisualType.TOTE_BAG
        ),
        CuratedFind(
            id = "find_knit_cardigan",
            title = "Relaxed Ribbed Button Cardigan",
            category = FindCategory.FASHION,
            shortDescription = "Soft mid-weight knit layer in neutral blush and oat tones for effortless pairing.",
            editorialNote = "An easy third piece over tailored trousers or weekend denim. The textured rib stitch adds subtle polish without feeling bulky.",
            priceNote = "Under $38 on Amazon",
            highlightTag = "Wardrobe Staple",
            amazonUrl = "https://www.amazon.com/s?k=womens+ribbed+knit+button+cardigan+neutral",
            highlights = listOf(
                "Breathable cotton-blend knit for year-round layering",
                "Tortoiseshell-style buttons for a tailored finish",
                "Relaxed drop-shoulder fit"
            ),
            isTrending = false,
            visualType = ProductVisualType.CARDIGAN
        ),
        CuratedFind(
            id = "find_retro_sunglasses",
            title = "Tortoise Oval Polarized Sunglasses",
            category = FindCategory.FASHION,
            shortDescription = "Lightweight vintage-inspired frames with UV400 polarized lenses for sunny errands.",
            editorialNote = "A classic oval frame flatters almost every face shape while cutting glare on bright drives and afternoon walks.",
            priceNote = "Under $20 on Amazon",
            highlightTag = "Everyday Favorite",
            amazonUrl = "https://www.amazon.com/s?k=oval+tortoise+polarized+sunglasses+women",
            highlights = listOf(
                "100% UV400 polarized lens protection",
                "Includes soft microfiber pouch and cleaning cloth",
                "Comfortable integrated nose pads"
            ),
            isTrending = false,
            visualType = ProductVisualType.SUNGLASSES
        ),

        // Beauty Favorites
        CuratedFind(
            id = "find_glow_serum",
            title = "Rosehip & Niacinamide Glow Drops",
            category = FindCategory.BEAUTY,
            shortDescription = "Lightweight hydrating serum that layers smoothly under daily sunscreen and makeup.",
            editorialNote = "A calm morning skincare step focused on barrier hydration and dewy radiance without heavy fragrance or sticky residue.",
            priceNote = "Under $26 on Amazon",
            highlightTag = "Trending Pick",
            amazonUrl = "https://www.amazon.com/s?k=niacinamide+hydrating+glow+drops+serum",
            highlights = listOf(
                "Fast-absorbing water-gel texture",
                "Pairs cleanly under moisturizer and SPF",
                "Travel-friendly glass dropper bottle"
            ),
            isTrending = true,
            visualType = ProductVisualType.GLOW_SERUM
        ),
        CuratedFind(
            id = "find_matte_claw_clips",
            title = "Neutral Matte Hair Claw Clip Set",
            category = FindCategory.BEAUTY,
            shortDescription = "Non-slip soft-touch clips in espresso, rose, and cream for quick, gentle updos.",
            editorialNote = "Keeps hair comfortably secured during skincare routines, desk work, or busy afternoons without tugging.",
            priceNote = "Under $12 on Amazon",
            highlightTag = "Editor Favorite",
            amazonUrl = "https://www.amazon.com/s?k=matte+neutral+hair+claw+clips+pack",
            highlights = listOf(
                "Matte soft-touch coating prevents slipping",
                "Strong spring hinge holds thick or fine hair",
                "4 versatile neutral & blush tones included"
            ),
            isTrending = false,
            visualType = ProductVisualType.CLAW_CLIPS
        ),
        CuratedFind(
            id = "find_makeup_brushes",
            title = "Plush Everyday Blending Brush Trio",
            category = FindCategory.BEAUTY,
            shortDescription = "Ultra-soft synthetic brushes with rose-gold ferrules for cream and powder essentials.",
            editorialNote = "Streamlines your morning routine down to three versatile shapes for concealer, blush, and setting powder.",
            priceNote = "Under $18 on Amazon",
            highlightTag = "Minimalist Kit",
            amazonUrl = "https://www.amazon.com/s?k=soft+synthetic+makeup+brush+set+blush+concealer",
            highlights = listOf(
                "Cruelty-free dense synthetic bristles",
                "Seamless cream and powder blending",
                "Easy to wash and quick to dry"
            ),
            isTrending = false,
            visualType = ProductVisualType.BRUSH_SET
        ),

        // Home Essentials
        CuratedFind(
            id = "find_amber_lamp",
            title = "Warm Ribbed Glass Table Lamp",
            category = FindCategory.HOME,
            shortDescription = "Soft ambient bedside glow with a brass-finished base and warm 2700K dimmable bulb.",
            editorialNote = "Swapping harsh overhead lights for warm accent lighting instantly makes bedrooms and reading corners feel calmer at night.",
            priceNote = "Under $42 on Amazon",
            highlightTag = "Trending Pick",
            amazonUrl = "https://www.amazon.com/s?k=ribbed+glass+warm+table+lamp+bedside",
            highlights = listOf(
                "Compact footprint ideal for nightstands and shelves",
                "Diffused warm light softens evening spaces",
                "Simple inline dimmer switch"
            ),
            isTrending = true,
            visualType = ProductVisualType.AMBER_LAMP
        ),
        CuratedFind(
            id = "find_waffle_throw",
            title = "Organic Cotton Waffle Throw Blanket",
            category = FindCategory.HOME,
            shortDescription = "Breathable woven texture in warm ivory for sofa draping and cozy movie nights.",
            editorialNote = "Light enough for spring evenings yet cozy enough to layer at the foot of a bed, with soft stonewashed texture.",
            priceNote = "Under $34 on Amazon",
            highlightTag = "Cozy Classic",
            amazonUrl = "https://www.amazon.com/s?k=cotton+waffle+weave+throw+blanket+ivory",
            highlights = listOf(
                "100% breathable pre-washed cotton",
                "Machine washable and softens over time",
                "Generous 50 x 70 inch throw sizing"
            ),
            isTrending = false,
            visualType = ProductVisualType.THROW_BLANKET
        ),
        CuratedFind(
            id = "find_ceramic_vase",
            title = "Matte Speckled Ceramic Vase",
            category = FindCategory.HOME,
            shortDescription = "Sculptural stoneware vessel sized for fresh eucalyptus, dried stems, or bookshelf styling.",
            editorialNote = "A quiet architectural accent that anchors entryway consoles and dining tables even when styled empty.",
            priceNote = "Under $24 on Amazon",
            highlightTag = "Shelf Accent",
            amazonUrl = "https://www.amazon.com/s?k=matte+ceramic+speckled+vase+minimalist",
            highlights = listOf(
                "Watertight glazed interior for fresh florals",
                "Textured matte stoneware exterior",
                "Protective felt pads on the base"
            ),
            isTrending = false,
            visualType = ProductVisualType.CERAMIC_VASE
        ),

        // Kitchen Finds
        CuratedFind(
            id = "find_gooseneck_kettle",
            title = "Matte Cream Gooseneck Electric Kettle",
            category = FindCategory.KITCHEN,
            shortDescription = "Precision pour spout and quick-boil stainless interior for morning tea and pour-over coffee.",
            editorialNote = "Clean countertop aesthetics meet reliable daily utility with auto shut-off and balanced handle ergonomics.",
            priceNote = "Under $55 on Amazon",
            highlightTag = "Trending Pick",
            amazonUrl = "https://www.amazon.com/s?k=matte+cream+gooseneck+electric+kettle",
            highlights = listOf(
                "1200W rapid boil with auto shut-off",
                "100% food-grade stainless steel interior",
                "Counterbalanced gooseneck pour control"
            ),
            isTrending = true,
            visualType = ProductVisualType.ELECTRIC_KETTLE
        ),
        CuratedFind(
            id = "find_ribbed_glass_mugs",
            title = "Fluted Borosilicate Iced Coffee Glasses",
            category = FindCategory.KITCHEN,
            shortDescription = "Set of 4 vintage-ribbed glasses with bamboo lids and reusable glass straws.",
            editorialNote = "Turns iced matcha, cold brew, or sparkling citrus water into a small afternoon ritual.",
            priceNote = "Under $22 on Amazon",
            highlightTag = "Coffee Bar Hit",
            amazonUrl = "https://www.amazon.com/s?k=fluted+ribbed+glass+cups+with+straws",
            highlights = listOf(
                "Thermal-shock resistant borosilicate glass",
                "Dishwasher safe glasses with snug lids",
                "16 oz capacity fits standard ice & espresso shots"
            ),
            isTrending = false,
            visualType = ProductVisualType.GLASS_MUGS
        ),

        // Organization
        CuratedFind(
            id = "find_drawer_dividers",
            title = "Modular Clear Vanity & Desk Trays",
            category = FindCategory.ORGANIZATION,
            shortDescription = "Interlocking non-slip acrylic compartments that tame junk drawers and skincare shelves.",
            editorialNote = "Visible categories make daily routines faster because every lip balm, pen, and hair clip has a clear home.",
            priceNote = "Under $20 on Amazon",
            highlightTag = "Clutter Solver",
            amazonUrl = "https://www.amazon.com/s?k=clear+modular+drawer+organizer+trays+set",
            highlights = listOf(
                "Includes 12 mix-and-match tray sizes",
                "Silicone feet keep trays from sliding",
                "Crystal-clear easy-wipe acrylic"
            ),
            isTrending = false,
            visualType = ProductVisualType.DRAWER_ORGANIZER
        ),
        CuratedFind(
            id = "find_pantry_jars",
            title = "Airtight Bamboo-Lid Pantry Canisters",
            category = FindCategory.ORGANIZATION,
            shortDescription = "Clear stackable jars with silicone seals for oats, coffee beans, pasta, and baking staples.",
            editorialNote = "Creates instant visual calm inside pantry cabinets while keeping dry ingredients fresher longer.",
            priceNote = "Under $36 on Amazon",
            highlightTag = "Pantry Refresh",
            amazonUrl = "https://www.amazon.com/s?k=airtight+glass+pantry+storage+jars+bamboo+lid",
            highlights = listOf(
                "Silicone gasket airtight seal",
                "Wide-mouth opening fits measuring cups",
                "Includes minimalist pantry label stickers"
            ),
            isTrending = false,
            visualType = ProductVisualType.PANTRY_JARS
        ),
        CuratedFind(
            id = "find_travel_pouch",
            title = "Lay-Flat Quilted Cosmetic Travel Case",
            category = FindCategory.ORGANIZATION,
            shortDescription = "Opens 180 degrees with zippered mesh pockets so you never dig to the bottom of a bag.",
            editorialNote = "Pack skincare, brushes, and jewelry neatly in one wipeable quilted pouch for weekend trips.",
            priceNote = "Under $19 on Amazon",
            highlightTag = "Travel Smart",
            amazonUrl = "https://www.amazon.com/s?k=lay+flat+quilted+makeup+travel+bag+organizer",
            highlights = listOf(
                "Wide lay-flat opening displays everything at once",
                "Dedicated brush slots and center divider",
                "Lightweight packable quilted fabric"
            ),
            isTrending = false,
            visualType = ProductVisualType.TRAVEL_POUCH
        ),

        // Lifestyle Picks
        CuratedFind(
            id = "find_insulated_tumbler",
            title = "40 oz Blush Insulated Straw Tumbler",
            category = FindCategory.LIFESTYLE,
            shortDescription = "Cup-holder friendly stainless steel bottle that keeps water ice-cold through the workday.",
            editorialNote = "A gentle nudge to stay hydrated at your desk or in the car with a comfortable ergonomic handle.",
            priceNote = "Under $30 on Amazon",
            highlightTag = "Daily Companion",
            amazonUrl = "https://www.amazon.com/s?k=40+oz+blush+insulated+tumbler+with+handle",
            highlights = listOf(
                "Double-wall vacuum insulation keeps drinks cold 24h",
                "Tapered base fits standard car cup holders",
                "Splash-resistant rotating straw lid"
            ),
            isTrending = false,
            visualType = ProductVisualType.TUMBLER
        ),
        CuratedFind(
            id = "find_linen_journal",
            title = "Linen Hardcover Daily Intention Planner",
            category = FindCategory.LIFESTYLE,
            shortDescription = "Thick 120gsm bleed-resistant pages with lay-flat binding for priorities and habit notes.",
            editorialNote = "Undated layouts let you pick up anytime without wasted pages—ideal for calm Sunday planning.",
            priceNote = "Under $17 on Amazon",
            highlightTag = "Mindful Routine",
            amazonUrl = "https://www.amazon.com/s?k=linen+hardcover+undated+daily+planner+120gsm",
            highlights = listOf(
                "120gsm ivory paper prevents ink ghosting",
                "180-degree lay-flat sewn binding",
                "Dual ribbon bookmarks and back pocket"
            ),
            isTrending = false,
            visualType = ProductVisualType.LINEN_JOURNAL
        ),
        CuratedFind(
            id = "find_desk_stand",
            title = "Foldable Aluminum Laptop & Tablet Riser",
            category = FindCategory.LIFESTYLE,
            shortDescription = "Raises your screen to eye level for better posture and tucks flat into a tote bag.",
            editorialNote = "A subtle ergonomic upgrade for home offices, kitchen counters, and coffee shop work sessions.",
            priceNote = "Under $25 on Amazon",
            highlightTag = "Work From Home",
            amazonUrl = "https://www.amazon.com/s?k=foldable+aluminum+laptop+stand+portable",
            highlights = listOf(
                "6 adjustable viewing angles",
                "Open ventilated frame prevents overheating",
                "Silicone pads protect device finish"
            ),
            isTrending = false,
            visualType = ProductVisualType.DESK_STAND
        )
    )

    val shoppingGuides: List<ShoppingGuide> = listOf(
        ShoppingGuide(
            id = "guide_fashion",
            title = "Everyday Fashion Essentials",
            subtitle = "Build a polished capsule of mix-and-match layers and dependable carryalls.",
            category = FindCategory.FASHION,
            readTimeMinutes = 4,
            intro = "A thoughtful everyday wardrobe starts with three dependable anchors: a structured bag that holds your day together, a breathable knit layer, and accessories that work across seasons.",
            sections = listOf(
                GuideSection(
                    heading = "1. Choose Structure Over Slouch for Work Bags",
                    body = "Totes with reinforced bases keep laptops, chargers, and notebooks separated instead of pooling at the bottom. Look for neutral pebble textures that pair easily with denim or blazers."
                ),
                GuideSection(
                    heading = "2. Layer With Soft Mid-Weight Knits",
                    body = "A ribbed cardigan bridges chilly morning commutes and warm afternoons. Neutral cream, oat, and dusty rose shades maximize outfit combinations without overflowing your closet."
                ),
                GuideSection(
                    heading = "3. Rely on Timeless Frames",
                    body = "Classic tortoise oval sunglasses instantly elevate casual errands while shielding your eyes with UV400 polarization."
                )
            ),
            featuredFindIds = listOf("find_structured_tote", "find_knit_cardigan", "find_retro_sunglasses")
        ),
        ShoppingGuide(
            id = "guide_home",
            title = "Practical Home Finds",
            subtitle = "Small texture and lighting upgrades that transform everyday spaces.",
            category = FindCategory.HOME,
            readTimeMinutes = 5,
            intro = "Refreshing a room doesn't require a major renovation. Warm secondary lighting, tactile throws, and one sculptural vessel can shift the mood of an entire corner in minutes.",
            sections = listOf(
                GuideSection(
                    heading = "1. Layer Warm Ambient Lighting",
                    body = "Turn off bright ceiling fixtures after sunset and rely on warm 2700K bedside or shelf lamps. Ribbed glass diffuses light softly without harsh glare."
                ),
                GuideSection(
                    heading = "2. Add Breathable Texture",
                    body = "Cotton waffle weaves bring visual depth to neutral sofas and beds while remaining lightweight enough for year-round lounging."
                ),
                GuideSection(
                    heading = "3. Keep Countertops Intentional",
                    body = "In the kitchen, swap bulky appliances for cohesive matte neutrals—like a slim gooseneck kettle paired with clear pantry canisters."
                )
            ),
            featuredFindIds = listOf("find_amber_lamp", "find_waffle_throw", "find_ceramic_vase", "find_gooseneck_kettle")
        ),
        ShoppingGuide(
            id = "guide_beauty",
            title = "Beauty and Self-Care Favorites",
            subtitle = "Streamlined morning glow steps and gentle hair accessories.",
            category = FindCategory.BEAUTY,
            readTimeMinutes = 4,
            intro = "The best self-care routine is one you actually look forward to on busy mornings—simple steps, gentle textures, and clutter-free vanity storage.",
            sections = listOf(
                GuideSection(
                    heading = "1. Focus on Hydrating Basics",
                    body = "A lightweight niacinamide and botanical serum layers cleanly under sunscreen without pilling, giving skin a rested, balanced finish."
                ),
                GuideSection(
                    heading = "2. Switch to Gentle Hair Hold",
                    body = "Soft-touch matte claw clips keep hair off your face during skincare without creasing or pulling."
                ),
                GuideSection(
                    heading = "3. Edit Your Brush Cup",
                    body = "Three well-shaped brushes for concealer, cream blush, and powder replace overflowing pouches and clean up in under two minutes."
                )
            ),
            featuredFindIds = listOf("find_glow_serum", "find_matte_claw_clips", "find_makeup_brushes")
        ),
        ShoppingGuide(
            id = "guide_smart_shopping",
            title = "Smart Shopping Ideas",
            subtitle = "How to curate an intentional Amazon wishlist and avoid impulse clutter.",
            category = FindCategory.ORGANIZATION,
            readTimeMinutes = 5,
            intro = "Intentional shopping means letting items sit on a curated wishlist before buying—matching real daily needs in your pantry, desk, and travel bag.",
            sections = listOf(
                GuideSection(
                    heading = "1. Measure Drawers & Shelves First",
                    body = "Before ordering modular organizers or pantry jars, measure drawer depth and shelf height so every inch works efficiently."
                ),
                GuideSection(
                    heading = "2. Use a Curated Wishlist as a Filter",
                    body = "Save candidates to your HerFinds favorites or shared Amazon Wishlist and revisit them after 48 hours. The pieces you still smile about are the ones worth ordering."
                ),
                GuideSection(
                    heading = "3. Prioritize Multi-Use Upgrades",
                    body = "Choose items you touch every single day: an insulated tumbler, a lay-flat travel pouch, or a portable laptop riser."
                )
            ),
            featuredFindIds = listOf("find_drawer_dividers", "find_pantry_jars", "find_travel_pouch", "find_desk_stand")
        )
    )

    val blogArticles: List<BlogArticle> = listOf(
        BlogArticle(
            id = "article_morning_ritual",
            categoryLabel = "LIFESTYLE",
            title = "5 Small Upgrades That Make Weekday Mornings Feel Calmer",
            excerpt = "From warm counter lighting to a quiet pour-over station, tiny habits set the tone before 9 AM.",
            readTimeMinutes = 4,
            publishedLabel = "Editorial Pick",
            bodyParagraphs = listOf(
                "Mornings feel rushed when every step asks you to hunt for something—keys at the bottom of a soft bag, hair ties lost in a vanity drawer, or mugs stacked precariously.",
                "Start by dedicating one small tray near your kettle and coffee glasses. Having fluted glassware and a precision gooseneck kettle ready turns five minutes of prep into a calm pause.",
                "Next, keep an undated linen planner open next to your insulated tumbler. Jotting down just three top priorities before checking messages protects your focus all morning."
            ),
            relatedFindIds = listOf("find_gooseneck_kettle", "find_ribbed_glass_mugs", "find_linen_journal")
        ),
        BlogArticle(
            id = "article_vanity_reset",
            categoryLabel = "ORGANIZATION",
            title = "The 15-Minute Vanity & Drawer Reset That Actually Stays Neat",
            excerpt = "Why clear interlocking trays and a lay-flat travel pouch stop beauty clutter before it starts.",
            readTimeMinutes = 3,
            publishedLabel = "Organization",
            bodyParagraphs = listOf(
                "Most drawer chaos happens because small items—lip tints, claw clips, hairpins, and travel minis—slide together every time a drawer opens.",
                "Empty one drawer onto a towel, keep only what you've used in the past month, and group items by frequency into non-slip modular trays.",
                "For items you carry between home and weekend trips, store them permanently in a lay-flat quilted pouch so packing takes seconds."
            ),
            relatedFindIds = listOf("find_drawer_dividers", "find_travel_pouch", "find_matte_claw_clips")
        ),
        BlogArticle(
            id = "article_capsule_carryall",
            categoryLabel = "FASHION",
            title = "What Fits Inside an Everyday Structured Tote (Without the Bulk)",
            excerpt = "Packing a slim laptop riser, polarized sunglasses, and hydration into one balanced work bag.",
            readTimeMinutes = 4,
            publishedLabel = "Fashion & Work",
            bodyParagraphs = listOf(
                "The secret to a comfortable tote isn't carrying less—it's keeping weight centered and items upright so your shoulder doesn't fight shifting pockets.",
                "Pair a structured tote with a slim folding aluminum stand and a narrow quilted pouch for lip balm, sunglasses, and earbuds.",
                "When everything has an upright slot, switching from office desk to dinner plans takes less than thirty seconds."
            ),
            relatedFindIds = listOf("find_structured_tote", "find_desk_stand", "find_retro_sunglasses")
        )
    )

    fun findById(id: String): CuratedFind? = curatedFinds.firstOrNull { it.id == id }
    fun guideById(id: String): ShoppingGuide? = shoppingGuides.firstOrNull { it.id == id }
    fun articleById(id: String): BlogArticle? = blogArticles.firstOrNull { it.id == id }
}
