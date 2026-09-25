package com.example.data.repository

import com.example.data.model.*

object PoetryData {
    val poems: List<LiteraryWork> = listOf(
        LiteraryWork(
            id = "poem_eagle",
            title = "The Eagle (A Fragment)",
            author = "Alfred Lord Tennyson",
            genre = LiteraryGenre.POETRY,
            category = ThemeCategory.NATURE,
            grade = 10,
            term = 1,
            fullTextOrExcerpt = """He clasps the crag with crooked hands;
Close to the sun in lonely lands,
Ring'd with the azure world, he stands.

The wrinkled sea beneath him crawls;
He watches from his mountain walls,
And like a thunderbolt he falls.""",
            summary = "A six-line fragment celebrating the majestic power, isolation, and sudden kinetic energy of an eagle perched high above the sea and swooping down upon its prey.",
            contextBackground = "Written by Alfred Lord Tennyson, Victorian Poet Laureate. The poem captures nature's sublime grandeur and unbridled sovereign power through vivid imagery.",
            keyThemes = listOf("Power of Nature", "Solitude & Majesty", "Freedom vs Dominance"),
            techniques = listOf(
                TechniqueAnalysis("Personification & Alliteration", "clasps the crag with crooked hands", "Hard 'c' alliteration emphasizes ruthless grip, while human hands personify the eagle as an ancient monarch."),
                TechniqueAnalysis("Hyperbole & Imagery", "Close to the sun in lonely lands", "Emphasizes extraordinary height, placing the eagle closer to celestial fire than human earth."),
                TechniqueAnalysis("Simile", "And like a thunderbolt he falls", "Conveys instantaneous speed, elemental power, and lethal precision in an explosive climax.")
            ),
            characters = listOf(
                CharacterProfile("The Eagle", "Majestic predatory bird", listOf("Solitary", "Powerful", "Vigilant"), "Depicted almost as a mythological monarch commanding sky and sea.")
            ),
            goldenQuotes = listOf(
                GoldenQuote("Ring'd with the azure world, he stands.", "Stanza 1", "Shows absolute supremacy, surrounded only by pure infinite blue sky.", listOf("Nature", "Majesty")),
                GoldenQuote("The wrinkled sea beneath him crawls", "Stanza 2", "Metaphor reduces the vast ocean to small wrinkled ripples from his supreme height.", listOf("Perspective", "Power")),
                GoldenQuote("And like a thunderbolt he falls.", "Stanza 2 Climax", "Simile of sudden, god-like, descending power.", listOf("Action", "Nature"))
            ),
            contextQuestions = listOf(
                ContextQuestionItem(
                    id = "ctx_eagle_1",
                    workTitle = "The Eagle (A Fragment)",
                    author = "Alfred Lord Tennyson",
                    extractQuote = "The wrinkled sea beneath him crawls;\nHe watches from his mountain walls,\nAnd like a thunderbolt he falls.",
                    questionB = "Who is watching from the mountain walls?",
                    questionC = "Explain the poetic effect of the line 'The wrinkled sea beneath him crawls'.",
                    questionD = "What qualities of the subject are brought out in this stanza?",
                    modelAnswerA = "These lines are taken from the poem 'The Eagle (A Fragment)' by Alfred Lord Tennyson.",
                    modelAnswerB = "The eagle is watching intently from high cliffs/mountain walls.",
                    modelAnswerC = "Personification and visual imagery make the giant ocean seem tiny, slow, and aged ('wrinkled', 'crawls'), highlighting the eagle's immense elevation.",
                    modelAnswerD = "The eagle is depicted as supremely patient and watchful, yet possessing terrifying speed and destructive power ('like a thunderbolt') when hunting."
                )
            ),
            essayPrompts = listOf(
                EssayPromptItem(
                    id = "essay_eagle_1",
                    workTitle = "The Eagle (A Fragment)",
                    genre = LiteraryGenre.POETRY,
                    title = "Grandeur and Power in 'The Eagle'",
                    prompt = "How does Tennyson bring out the majesty and power of nature in 'The Eagle'?",
                    keyPoints = listOf("Use of vertical perspective and elevation", "Personification ('crooked hands')", "Imagery of the sea reduced to crawling wrinkles", "Simile of thunderbolt closing with explosive energy"),
                    peelStructure = "Point: Tennyson elevates the bird to an untouchable ruler.\nEvidence: 'Close to the sun in lonely lands'.\nExplanation: Hyperbole removes him from ordinary terrestrial limits.\nLink: Demonstrates nature's sublime grandeur.",
                    modelEssaySample = "In 'The Eagle', Alfred Lord Tennyson crafts an intense portrait of predatory majesty..."
                )
            )
        ),
        LiteraryWork(
            id = "poem_terrorist",
            title = "The Terrorist, He's Watching",
            author = "Wislawa Szymborska",
            genre = LiteraryGenre.POETRY,
            category = ThemeCategory.CONFLICT,
            grade = 10,
            term = 2,
            fullTextOrExcerpt = """The bomb in the bar will explode at thirteen twenty.
Now it's just thirteen sixteen.
There's still time for some to go in,
And some to come out.

The terrorist has already crossed the street.
That distance keeps him out of danger,
and what a view- just like the movies:
A woman in a yellow jacket, she's going in.
A man in dark glasses, he's coming out.
Teenagers in jeans, they're talking.
Thirteen seventeen and four seconds.
The short one, he's lucky, he's getting on a scooter,
but the tall one, he's going in...

Thirteen twenty exactly.
This waiting, it's taking forever.
Any second now.
No, not yet.
Yes, now.
The bomb, it explodes.""",
            summary = "A chilling, minute-by-minute account of a terrorist observing a public bar from across the street, watching unsuspecting ordinary people enter and exit before the explosion.",
            contextBackground = "Nobel Laureate Wislawa Szymborska reflects on modern violence, the chilling detachment of perpetrators, and the terrifying role of trivial chance in life and death.",
            keyThemes = listOf("Cruelty of Terrorism", "Randomness of Fate", "Cold Detachment vs Human Vulnerability"),
            techniques = listOf(
                TechniqueAnalysis("Cinematic Countdown", "Thirteen seventeen and four seconds... Thirteen twenty exactly.", "Precise objective timestamping builds agonizing suspense and emphasizes mechanical inevitability."),
                TechniqueAnalysis("Irony of Triviality", "he goes back in for his crummy gloves", "Ordinary forgotten items dictate survival or horrific death, exposing life's absurdity."),
                TechniqueAnalysis("Detached Tone", "and what a view- just like the movies", "Simile highlights the terrorist's complete lack of empathy, treating slaughter as mere cinema.")
            ),
            characters = listOf(
                CharacterProfile("The Terrorist", "Cold observer/bomber", listOf("Calculating", "Unemotional", "Voyeuristic"), "Views human beings as pawns in a movie-like spectacle.")
            ),
            goldenQuotes = listOf(
                GoldenQuote("The short one, he's lucky, he's getting on a scooter, but the tall one, he's going in.", "Stanza 3", "Sharp contrast highlighting sheer coincidence determining life and death.", listOf("Fate", "Chance")),
                GoldenQuote("at thirteen twenty minus ten seconds he goes back in for his crummy gloves.", "Stanza 6", "Pathos of an ordinary man sealing his doom over trivial worthless gloves.", listOf("Irony", "Tragedy")),
                GoldenQuote("Yes, now. The bomb, it explodes.", "Final lines", "Abrupt, matter-of-fact termination showing the blunt finality of terror.", listOf("Violence", "Reality"))
            ),
            contextQuestions = listOf(
                ContextQuestionItem(
                    id = "ctx_terrorist_1",
                    workTitle = "The Terrorist, He's Watching",
                    author = "Wislawa Szymborska",
                    extractQuote = "The short one, he's lucky, he's getting on a scooter,\nbut the tall one, he's going in.",
                    questionB = "Who is watching these young people?",
                    questionC = "Why is the short one considered 'lucky'?",
                    questionD = "What thematic message does this contrast reveal about fate and terrorism?",
                    modelAnswerA = "From 'The Terrorist, He's Watching' by Polish poet Wislawa Szymborska.",
                    modelAnswerB = "The bomber/terrorist who planted the explosive device across the street.",
                    modelAnswerC = "He is lucky because mounting his scooter carries him away from the blast radius just seconds before detonation.",
                    modelAnswerD = "It highlights the blind, absurd randomness of life and death in terror attacks—survival hinges entirely on arbitrary, minute choices."
                )
            ),
            essayPrompts = listOf(
                EssayPromptItem(
                    id = "essay_terrorist_1",
                    workTitle = "The Terrorist, He's Watching",
                    genre = LiteraryGenre.POETRY,
                    title = "Suspense and Detachment in 'The Terrorist, He's Watching'",
                    prompt = "Discuss how Szymborska uses time and a detached narrative voice to critique modern terrorism.",
                    keyPoints = listOf("Chronometer-like timestamps creating tension", "The callous movie spectator metaphor", "The insignificance of victim profiles to the terrorist", "The role of luck and chance in survival"),
                    peelStructure = "Point: The poem adopts an unemotional observational stance.\nEvidence: 'and what a view- just like the movies'.\nExplanation: Emphasizes the psychological distance between extremist ideology and human suffering.\nLink: Exposes the monstrous inhumanity of terrorism.",
                    modelEssaySample = "In 'The Terrorist, He's Watching', Wislawa Szymborska explores the horrifying mechanics of senseless violence..."
                )
            )
        ),
        LiteraryWork(
            id = "poem_war_is_kind",
            title = "War is Kind",
            author = "Stephen Crane",
            genre = LiteraryGenre.POETRY,
            category = ThemeCategory.CONFLICT,
            grade = 11,
            term = 1,
            fullTextOrExcerpt = """Do not weep, maiden, for war is kind
Because your lover threw wild hands towards the sky
And the affrighted steed ran on alone
Do not weep
War is kind.

Hoarse, booming drums of the regiment
Little souls who thirst for fight
These men were born to drill and die
The unexplained glory flies above them
Great is the battle god, great and his kingdom
A field where a thousand corpses lie...""",
            summary = "A bitter anti-war satire where the refrain 'War is kind' is repeatedly juxtaposed against gruesome realities of battlefield death suffered by lovers, fathers, and sons.",
            contextBackground = "Written during the Spanish-American War era by Stephen Crane, famous for 'The Red Badge of Courage'. Crane exposes the deception of patriotic war propaganda.",
            keyThemes = listOf("Horror and Futility of War", "Anti-militarism", "Sarcastic Critique of False Glory"),
            techniques = listOf(
                TechniqueAnalysis("Irony / Refrain", "Do not weep, maiden, for war is kind", "The refrain is bitterly sarcastic; every graphic description of dying exposes the lie that war is benevolent."),
                TechniqueAnalysis("Juxtaposition", "swift blazing flag / field where a thousand corpses lie", "Contrasts glamorous martial symbols with brutal mass graves."),
                TechniqueAnalysis("Metaphor", "Mother whose heart hung humble as a button", "Compares maternal grief to a cheap, ordinary button on a military shroud, showing how common and undervalued maternal sacrifice is.")
            ),
            characters = listOf(
                CharacterProfile("The Bereaved (Maiden, Babe, Mother)", "Innocent survivors", listOf("Grieving", "Powerless", "Shattered"), "Represent the true victims of jingoistic warfare left to mourn alone.")
            ),
            goldenQuotes = listOf(
                GoldenQuote("Do not weep, maiden, for war is kind", "Stanza 1 Refrain", "Biting verbal irony establishing the poem's anti-war thesis.", listOf("Irony", "War")),
                GoldenQuote("These men were born to drill and die", "Stanza 2", "Bleak indictment of military brainwashing reducing youth to cannon fodder.", listOf("Soldiers", "Critique")),
                GoldenQuote("Mother whose heart hung humble as a button / On the bright splendid shroud of your son", "Stanza 5", "Poignant image contrasting empty military splendor with intimate maternal heartbreak.", listOf("Grief", "Sacrifice"))
            ),
            contextQuestions = listOf(
                ContextQuestionItem(
                    id = "ctx_war_1",
                    workTitle = "War is Kind",
                    author = "Stephen Crane",
                    extractQuote = "Do not weep babe, for war is kind\nBecause your father tumbled in the yellow trenches\nRaged at his breast, gulped and died.",
                    questionB = "Who is being addressed here?",
                    questionC = "Identify the literary device in 'for war is kind' and explain its significance.",
                    questionD = "How does the description of the father's death contradict the stated idea that war is kind?",
                    modelAnswerA = "From 'War is Kind' by American writer Stephen Crane.",
                    modelAnswerB = "An orphaned infant/babe whose father was killed in the war.",
                    modelAnswerC = "Verbal irony / sarcasm. War is savage and cruel; calling it 'kind' forces the reader to confront the horrific falsehood of patriotic glorification.",
                    modelAnswerD = "The father 'tumbled in yellow trenches', 'raged at his breast', and 'gulped and died' in agonizing pain alone, proving war brings only brutal tragedy."
                )
            ),
            essayPrompts = listOf(
                EssayPromptItem(
                    id = "essay_war_1",
                    workTitle = "War is Kind",
                    genre = LiteraryGenre.POETRY,
                    title = "The Power of Irony in 'War is Kind'",
                    prompt = "Examine how Crane employs bitter irony to dismantle the romantic myth of battlefield heroism.",
                    keyPoints = listOf("Repeated ironic refrain 'War is kind'", "Graphic physical depictions of dying", "Critique of the 'battle god' and military pomp", "The emotional toll on loved ones left behind"),
                    peelStructure = "Point: Crane's refrain operates through searing verbal irony.\nEvidence: 'Do not weep, maiden, for war is kind / Because your lover threw wild hands...'.\nExplanation: The immediate grotesque image of the dying lover shreds the consolation of kindness.\nLink: Exposes war as callous butchery.",
                    modelEssaySample = "Stephen Crane's 'War is Kind' is one of literature's most scathing attacks on military romanticism..."
                )
            )
        ),
        LiteraryWork(
            id = "poem_caged_bird",
            title = "I Know Why the Caged Bird Sings",
            author = "Maya Angelou",
            genre = LiteraryGenre.POETRY,
            category = ThemeCategory.SOCIETY,
            grade = 11,
            term = 1,
            fullTextOrExcerpt = """The free bird leaps
on the back of the wind
and floats downstream
till the current ends
and dips his wings
in the orange sun rays
and dares to claim the sky.

But a bird that stalks
down his narrow cage
can seldom see through
his bars of rage
his wings are clipped and
his feet are tied
so he opens his throat to sing.

The caged bird sings
with fearful trill
of the things unknown
but longed for still
and his tune is heard
on the distant hill for the caged bird
sings of freedom...""",
            summary = "A powerful extended metaphor contrasting the boundless joy of the free bird with the agony, imprisonment, and defiant song of the caged bird.",
            contextBackground = "Written by American poet and civil rights activist Maya Angelou. Reflects the historic racial oppression of African Americans and the indestructible yearning for freedom.",
            keyThemes = listOf("Oppression vs Freedom", "Racial Injustice", "Resilience & The Voice of Hope"),
            techniques = listOf(
                TechniqueAnalysis("Extended Metaphor", "Free bird vs Caged bird", "The free bird symbolizes white privilege and uninhibited liberty; the caged bird symbolizes racially oppressed people fighting for dignity."),
                TechniqueAnalysis("Auditory Imagery / Paradox", "sings with fearful trill of things unknown", "Though terrified and bound, the bird's song carries across hills, proving that the spirit of freedom cannot be silenced."),
                TechniqueAnalysis("Tactile Imagery", "wings are clipped and feet are tied", "Physical constraints demonstrate systematic disenfranchisement and structural violence.")
            ),
            characters = listOf(
                CharacterProfile("The Free Bird", "Symbol of privileged liberty", listOf("Carefree", "Entitled", "Unchecked"), "Claims the sky effortlessly as if the universe exists solely for it."),
                CharacterProfile("The Caged Bird", "Symbol of oppressed humanity", listOf("Resilient", "Defiant", "Longing"), "Though trapped behind 'bars of rage', its voice remains undefeated.")
            ),
            goldenQuotes = listOf(
                GoldenQuote("The free bird leaps on the back of the wind... and dares to claim the sky.", "Stanza 1", "Illustrates carefree luxury and unrestricted agency.", listOf("Freedom", "Privilege")),
                GoldenQuote("his wings are clipped and his feet are tied so he opens his throat to sing.", "Stanza 2", "Ultimate assertion of defiance: expression remains free when body is caged.", listOf("Resilience", "Voice")),
                GoldenQuote("for the caged bird sings of freedom.", "Refrain", "Reiterates the immortal human demand for self-determination and equality.", listOf("Freedom", "Hope"))
            ),
            contextQuestions = listOf(
                ContextQuestionItem(
                    id = "ctx_caged_1",
                    workTitle = "I Know Why the Caged Bird Sings",
                    author = "Maya Angelou",
                    extractQuote = "The caged bird sings\nwith fearful trill\nof the things unknown\nbut longed for still\nand his tune is heard\non the distant hill",
                    questionB = "Why does the bird sing with a 'fearful trill'?",
                    questionC = "What are the 'things unknown but longed for still'?",
                    questionD = "Comment on the significance of the bird's song being heard 'on the distant hill'.",
                    modelAnswerA = "Taken from 'I Know Why the Caged Bird Sings' by Maya Angelou.",
                    modelAnswerB = "Because it has never experienced freedom and suffers constant captivity, causing anxiety alongside desperate yearning.",
                    modelAnswerC = "Freedom, liberty, justice, and the natural dignity that has been denied to it throughout its life.",
                    modelAnswerD = "It proves that despite physical containment ('clipped wings, tied feet'), the message of freedom cannot be suppressed; it echoes far and wide to inspire others."
                )
            ),
            essayPrompts = listOf(
                EssayPromptItem(
                    id = "essay_caged_1",
                    workTitle = "I Know Why the Caged Bird Sings",
                    genre = LiteraryGenre.POETRY,
                    title = "The Dual Symbolism in Angelou's 'Caged Bird'",
                    prompt = "Analyze how Angelou uses the juxtaposition between the free bird and the caged bird to expose systemic injustice.",
                    keyPoints = listOf("Contrasting verbs of mobility vs containment", "Sensory descriptions of sky vs narrow bars", "Singing as a metaphor for resistance and art", "Relevance to civil rights and universal oppression"),
                    peelStructure = "Point: Angelou contrasts physical freedom with claustrophobic restriction.\nEvidence: The free bird 'dares to claim the sky' while the caged bird 'stalks down his narrow cage'.\nExplanation: Emphasizes the disparity between inherited privilege and enforced subjugation.\nLink: Exposes the profound cruelty of societal disenfranchisement.",
                    modelEssaySample = "In 'I Know Why the Caged Bird Sings', Maya Angelou crafts a poignant allegory of oppression and endurance..."
                )
            )
        ),
        LiteraryWork(
            id = "poem_big_match",
            title = "Big Match, 1983",
            author = "Yasmine Gooneratne",
            genre = LiteraryGenre.POETRY,
            category = ThemeCategory.SOCIETY,
            grade = 10,
            term = 2,
            fullTextOrExcerpt = """Glimpsing the headlines in the newspapers,
tourists scuttle for cover, cancel their options
on rooms with views of temple and holy mountain.
“Flash point in Paradise.” “Racial pot boils over.”
...
We talk of “Forty Eight” and “Fifty Six”,
of freedom and the treacherous politics
of language; see the first sparks of this hate
fanned into flame in Nineteen Fifty Eight...
Blood on their khaki uniforms, three boys lie dying;
a crowd looks silently the other way.
Near the wheels of his smashed bicycle
at the corner of Duplication Road a child lies dead
and two policemen look the other way...
Sri Lanka burns alive.""",
            summary = "A devastating reflection on the July 1983 anti-Tamil pogrom ('Black July') in Sri Lanka, framing communal violence through the ironic metaphor of the island's annual school cricket rivalry.",
            contextBackground = "Written by eminent Sri Lankan-Australian poet Yasmine Gooneratne. Addresses the horrors of July 1983, the complicity of bystanders and authorities, and the unraveling of national unity.",
            keyThemes = listOf("Ethnic Violence & Black July", "Apathy of Authorities & Bystanders", "Tragic Irony of Cricket Metaphor"),
            techniques = listOf(
                TechniqueAnalysis("Central Metaphor", "'Big Match' fever", "Subverts the cherished celebratory ritual of Sri Lankan school cricket to expose lethal communal violence, where 'scores' mean casualties."),
                TechniqueAnalysis("Repetition / Parallelism", "a crowd looks silently the other way... two policemen look the other way", "Critiques collective guilt, cowardice, and institutional failure during mob pogroms."),
                TechniqueAnalysis("Sensory Realism & Imagery", "smashing of bicycles, burning shops curling like old photographs", "Evokes concrete Colombo streets (Duplication Road, Pettah) giving historical immediacy.")
            ),
            characters = listOf(
                CharacterProfile("The Telephone Friend", "Intellectual caught in curfew", listOf("Stoic", "Resigned", "Cynical"), "Keeps watch with dim books while preparing torches to burn him before his books."),
                CharacterProfile("The Bystanders & Police", "Silent spectators", listOf("Complicit", "Indifferent", "Passive"), "Look the other way while innocent lives are obliterated.")
            ),
            goldenQuotes = listOf(
                GoldenQuote("and Big Match fever, flaring high and fast, has both sides in its grip and promises dizzier scores than any at the oval.", "Stanza 4", "Terrifying irony connecting a friendly sporting rivalry to deadly sectarian bloodshed.", listOf("Irony", "Conflict")),
                GoldenQuote("a crowd looks silently the other way... two policemen look the other way", "Stanza 8", "Exposes the moral bankruptcy and culpability of state and society.", listOf("Apathy", "Injustice")),
                GoldenQuote("screaming across our screens her agony at last exposed, Sri Lanka burns alive.", "Final lines", "Climactic visceral declaration of national catastrophe.", listOf("Tragedy", "Nation"))
            ),
            contextQuestions = listOf(
                ContextQuestionItem(
                    id = "ctx_big_match_1",
                    workTitle = "Big Match, 1983",
                    author = "Yasmine Gooneratne",
                    extractQuote = "Near the wheels of his smashed bicycle\nat the corner of Duplication Road a child lies dead\nand two policemen look the other way",
                    questionB = "Where does this scene take place?",
                    questionC = "What does the reaction of the two policemen signify?",
                    questionD = "How does this image contribute to the overall tone and purpose of the poem?",
                    modelAnswerA = "Taken from 'Big Match, 1983' by Sri Lankan poet Yasmine Gooneratne.",
                    modelAnswerB = "At the corner of Duplication Road in Colombo during the ethnic riots of July 1983.",
                    modelAnswerC = "It signifies the dereliction of duty, cowardice, and tacit state complicity during the violence.",
                    modelAnswerD = "The horrific image of an innocent child next to a smashed bicycle brings home the tragic reality of mob savagery, shattering any euphemism or political rhetoric."
                )
            ),
            essayPrompts = listOf(
                EssayPromptItem(
                    id = "essay_big_match_1",
                    workTitle = "Big Match, 1983",
                    genre = LiteraryGenre.POETRY,
                    title = "The Satirical Use of the Cricket Metaphor",
                    prompt = "How effectively does Yasmine Gooneratne use the metaphor of a 'Big Match' to comment on the tragic events of 1983?",
                    keyPoints = listOf("Irony of cricket as national passion transformed into sectarian slaughter", "Historical milestones ('Forty Eight', 'Fifty Six')", "The chilling detachment of ordinary citizens looking away", "Loss of innocence and destruction of multi-ethnic harmony"),
                    peelStructure = "Point: Gooneratne ironically contrasts schoolboy sport with mob violence.\nEvidence: 'promises dizzier scores than any at the oval'.\nExplanation: The 'scores' are human corpses, exposing the sick competitive hatred.\nLink: Challenges the nation's conscience.",
                    modelEssaySample = "In 'Big Match, 1983', Yasmine Gooneratne uses one of Sri Lanka's beloved cultural fixtures..."
                )
            )
        )
    )
}
