package com.example.data.repository

import com.example.data.model.*

object DramaNovelData {
    val dramaAndNovels: List<LiteraryWork> = listOf(
        LiteraryWork(
            id = "drama_crane",
            title = "Twilight of a Crane (Yuzuru)",
            author = "Junji Kinoshita",
            genre = LiteraryGenre.DRAMA,
            category = ThemeCategory.GREED_LOVE,
            grade = 11,
            term = 1,
            fullTextOrExcerpt = """TSU: Yohyo, you've saved my life. You were once so innocent and kind that you could take the arrow out of my back solely through tender-heartedness...
I was so glad to come to you... And when I first wove the cloth with my feathers, you were as pleased as a child. Then, in spite of the pain, I wove them again and again. But you- my dear, you exchanged it every time for the thing called "money"...
YOHYO: Yes, I want money... Weave the stuff right away! I'll go to Kyoto! I'll make big money! If you say you can't, I'll leave you!
TSU: Yohyo, never look at me while I weave...
(Sodo and Unzu peep through the crevice, followed by Yohyo. They see a real crane plucking its own feathers on the loom).
TSU: You saw me after all... I've grown thin because of this... I've used up all the feathers I can possibly spare. Now I have just enough left to fly...
(A crane flies into the snowy twilight sky, flying crookedly).""",
            summary = "A poetic folk-drama based on the Japanese folktale 'Tsuru no Ongaeshi'. Tsu, a crane who transformed into a human woman out of gratitude to Yohyo for saving her life, weaves exquisite fabric (Senba-Ori) from her own plucked feathers. Corrupted by greedy villagers Sodo and Unzu, Yohyo demands more cloth for money and violates the sacred taboo of peeping into the weaving room. Tsu is forced to abandon him forever, flying into the twilight as a crane.",
            contextBackground = "Written by celebrated Japanese playwright Junji Kinoshita in 1949. Acts as an allegory for post-WWII Japan, critiquing Western-style commercialism destroying traditional spiritual purity and love.",
            keyThemes = listOf("Love vs Commercialism & Greed", "Loss of Innocence", "Violation of Sacred Trust", "Spiritual Sacrifice"),
            techniques = listOf(
                TechniqueAnalysis("Folkloric Allegory", "Tsu as the Crane / Spirit of Nature", "Represents unconditional love and self-giving art, while Sodo and Unzu represent capitalism and human avarice."),
                TechniqueAnalysis("Motif of Children's Song", "'Kagome, Kagome... bird in the cage'", "Foreshadows Tsu's entrapment in human greed and her eventual departure."),
                TechniqueAnalysis("Dramatic Irony & Taboo", "Peeping into the loom room", "The prohibition against viewing the transformation underscores the boundary between the sacred and the profane.")
            ),
            characters = listOf(
                CharacterProfile("Tsu", "The Crane Wife", listOf("Pure", "Self-sacrificing", "Tragic"), "Willing to pluck her flesh and feathers for love, but cannot survive in a world corrupted by money."),
                CharacterProfile("Yohyo", "Peasant husband", listOf("Innocent yet easily swayed", "Greedy", "Regretful"), "Initially simple and loving, he succumbs to Sodo's promises of Kyoto and wealth."),
                CharacterProfile("Sodo & Unzu", "Corrupt villagers", listOf("Manipulative", "Mercenary", "Callous"), "Villains who exploit Yohyo's naivety to profit from Tsu's life-blood.")
            ),
            goldenQuotes = listOf(
                GoldenQuote("You are moving to the other world where I can never live. You are casting your lot with those malicious, terrible people who shot me with an arrow.", "Tsu's Monologue", "Articulates the irreconcilable divide between the pure realm of love and the violent human world of commerce.", listOf("Purity", "Corruption")),
                GoldenQuote("Weave the cloth. If you say you can’t, I’ll leave you!", "Yohyo's Ultimatum", "The tragic turning point where Yohyo weaponizes love to extort wealth, sealing the relationship's destruction.", listOf("Greed", "Betrayal")),
                GoldenQuote("I’ve used up all the feathers I can possibly spare... Now I have just enough left to fly.", "Tsu's Farewell", "Heartbreaking physical embodiment of sacrifice—she has given everything except the bare minimum to survive.", listOf("Sacrifice", "Farewell"))
            ),
            contextQuestions = listOf(
                ContextQuestionItem(
                    id = "ctx_crane_1",
                    workTitle = "Twilight of a Crane (Yuzuru)",
                    author = "Junji Kinoshita",
                    extractQuote = "“I’ve used up all the feathers I can possibly spare.......... Now I have just enough left to fly..........”",
                    questionB = "Who speaks these words and to whom?",
                    questionC = "Why has the speaker used up her feathers?",
                    questionD = "What consequence does this have for the relationship between the speaker and listener?",
                    modelAnswerA = "Taken from the Japanese drama 'Twilight of a Crane' by Junji Kinoshita.",
                    modelAnswerB = "Tsu, the crane wife, speaks to her husband Yohyo.",
                    modelAnswerC = "She plucked them from her own body to weave the miraculous 'Senba-Ori' cloth because Yohyo demanded it for money.",
                    modelAnswerD = "It marks the irreversible end of their marriage. Having lost almost all her physical strength and had her sacred secret violated by Yohyo peeping, she must revert to bird form and leave forever."
                )
            ),
            essayPrompts = listOf(
                EssayPromptItem(
                    id = "essay_crane_1",
                    workTitle = "Twilight of a Crane (Yuzuru)",
                    genre = LiteraryGenre.DRAMA,
                    title = "The Corrupting Influence of Money in 'Twilight of a Crane'",
                    prompt = "Examine how Kinoshita uses Yohyo's gradual corruption to explore the destructive power of commercial greed.",
                    keyPoints = listOf("Yohyo's initial innocence and pastoral simplicity", "The manipulation of Sodo and Unzu dangling Kyoto's luxuries", "Tsu's physical deterioration mirroring Yohyo's moral decay", "The tragic climax of permanent separation"),
                    peelStructure = "Point: Kinoshita illustrates how money displaces genuine affection with coercion.\nEvidence: Yohyo threatens Tsu: 'Weave the cloth. If you say you can't, I'll leave you!'.\nExplanation: He adopts the predatory capitalist mindset of Sodo, destroying his marital bond.\nLink: Culminates in irrecoverable loss.",
                    modelEssaySample = "Junji Kinoshita's 'Twilight of a Crane' is a haunting fable about the toxic collision between pure love and material greed..."
                )
            )
        ),
        LiteraryWork(
            id = "drama_bear",
            title = "The Bear (A Joke in One Act)",
            author = "Anton Chekhov",
            genre = LiteraryGenre.DRAMA,
            category = ThemeCategory.FARCE_SATIRE,
            grade = 10,
            term = 3,
            fullTextOrExcerpt = """POPOVA: When Nicolai Mihailovitch died, life lost all its meaning for me. I vowed never to the end of my days to cease to wear mourning...
SMIRNOV: Madam, your late husband died in my debt for 1,200 roubles for oats. I must pay the interest tomorrow! Pay me the money today!
POPOVA: I haven't any spare cash! Wait until my steward returns!
SMIRNOV: I shan't leave here until she pays!
POPOVA: You're a boor! A coarse bear! A Bourbon! A monster!
SMIRNOV: Pistols! We'll fight it out! Equality of rights!
POPOVA: With pistols? Very well! I'll bring my husband's revolvers!
SMIRNOV: What a woman! Not a sour-faced jellybag, but fire, gunpowder, a rocket! I like her! Will you be my wife?
POPOVA: Get away from me! Let's fight!
(A prolonged kiss as Luka enters with an axe and the servants with pitchforks).
POPOVA: Luka, tell them in the stables that Toby isn't to have any oats at all today.""",
            summary = "A masterclass in 19th-century comic farce. Elena Popova, an ostentatiously grieving widow locked in melodramatic seclusion, clashes with Grigory Smirnov, an explosive creditor demanding payment for horse oats. Their ferocious shouting match escalates into a pistol duel challenge, which unexpectedly ignites violent mutual passion, ending in a breathless kiss.",
            contextBackground = "Written by Russian playwright Anton Chekhov in 1888. Subtitled 'A Joke in One Act', it satirizes romantic posturing, hypocritical mourning, and the volatile absurdity of human passions.",
            keyThemes = listOf("Appearance vs Reality in Grief", "The Absurdity of Romantic Pretense", "Duel of the Sexes & Inevitable Attraction"),
            techniques = listOf(
                TechniqueAnalysis("Farce & Comic Timing", "From furious mortal duel to instant marriage proposal", "Exposes how rage and attraction are two sides of the same volatile emotional energy."),
                TechniqueAnalysis("Satirical Hypocrisy", "Popova's devotion to her unfaithful late husband", "Popova locks herself away to prove moral superiority over her philandering spouse, powdering her face while weeping."),
                TechniqueAnalysis("The 'Oats for Toby' Motif", "From 'extra feed of oats' to 'no oats at all today'", "Toby the horse represents Nicolai's memory; cancelling Toby's oats symbolizes Popova abandoning her dead husband for Smirnov.")
            ),
            characters = listOf(
                CharacterProfile("Elena Popova", "Wealthy young widow", listOf("Melodramatic", "Proud", "Spirited"), "Poses as a grief-stricken nun-like widow but reveals fierce temper and passion."),
                CharacterProfile("Grigory Smirnov", "Ex-artillery lieutenant & landowner", listOf("Blunt", "Volatile", "Passionate"), "Known as 'the Bear', he despises women yet falls hopelessly in love with Popova's fiery spirit."),
                CharacterProfile("Luka", "Elderly footman", listOf("Panicky", "Traditional", "Comic relief"), "Constantly clutches his heart in comedic panic when duels erupt.")
            ),
            goldenQuotes = listOf(
                GoldenQuote("You may have buried yourself alive, but you haven’t forgotten to powder your face!", "Smirnov to Popova", "Punctures Popova's exaggerated performance of martyrdom with sharp comic realism.", listOf("Satire", "Vanity")),
                GoldenQuote("She is a woman! That’s the sort I can understand! A real woman! Not a sour-faced jellybag, but fire, gunpowder, a rocket!", "Smirnov's Aside", "The hilarious turning point where masculine belligerence transforms into romantic infatuation.", listOf("Humour", "Passion")),
                GoldenQuote("Luka, tell them in the stables that Toby isn’t to have any oats at all to-day.", "Popova's Curtain Line", "Brilliant visual and thematic resolution signalling Popova's complete romantic transition.", listOf("Irony", "Resolution"))
            ),
            contextQuestions = listOf(
                ContextQuestionItem(
                    id = "ctx_bear_1",
                    workTitle = "The Bear (A Joke in One Act)",
                    author = "Anton Chekhov",
                    extractQuote = "POPOVA: Luka, tell them in the stables that Toby isn’t to have any oats at all to-day.",
                    questionB = "When and under what circumstances does Popova say this?",
                    questionC = "Who is Toby, and why is this instruction significant compared to her earlier orders?",
                    questionD = "How does this line bring a humorous and conclusive ending to the play?",
                    modelAnswerA = "Taken from Anton Chekhov's one-act farce 'The Bear'.",
                    modelAnswerB = "Popova speaks this line at the very end of the play right after sharing a passionate embrace and kiss with Smirnov.",
                    modelAnswerC = "Toby was her deceased husband Nicolai's favourite horse. Earlier she repeatedly ordered Luka to give Toby 'an extra feed of oats' as tribute to her late husband's memory.",
                    modelAnswerD = "Cancelling Toby's oats humorously signals that her theatrical, year-long vow of eternal mourning for her dead husband is instantly discarded now that she has fallen for Smirnov."
                )
            ),
            essayPrompts = listOf(
                EssayPromptItem(
                    id = "essay_bear_1",
                    workTitle = "The Bear (A Joke in One Act)",
                    genre = LiteraryGenre.DRAMA,
                    title = "Farce and the Deconstruction of Romantic Grief",
                    prompt = "How does Chekhov use dramatic devices and comedic exaggeration to expose false sentimentality in 'The Bear'?",
                    keyPoints = listOf("Popova's theatrical pose of eternal bereavement", "Smirnov's misogynistic bluster crumbling under real attraction", "The absurdity of the pistol duel between a creditor and a widow", "The Toby motif as a symbol of emotional transition"),
                    peelStructure = "Point: Chekhov satirizes the theatricality of mourning.\nEvidence: Smirnov mocks her: 'You may have buried yourself alive, but you haven't forgotten to powder your face!'.\nExplanation: Unmasks Popova's grief as an audience-seeking vanity rather than genuine devastation.\nLink: Sets up the farcical reversal of the climax.",
                    modelEssaySample = "In Anton Chekhov's sparkling farce 'The Bear', grief is treated not as a solemn tragedy..."
                )
            )
        ),
        LiteraryWork(
            id = "novel_prince",
            title = "The Prince and the Pauper",
            author = "Mark Twain",
            genre = LiteraryGenre.NOVEL,
            category = ThemeCategory.CLASS_IDENTITY,
            grade = 10,
            term = 2,
            fullTextOrExcerpt = """Tom Canty, born in the filth of Offal Court, London, dreams of royalty. Prince Edward Tudor, born on the same day in the splendour of Westminster Palace, longs for freedom to play in the mud.
When they meet and exchange clothes out of curiosity, they discover they are identical twins in appearance. Prince Edward is cast out into the merciless London streets as a beggar, while Tom is trapped in court, believed by all to have gone mad.
Through their agonizing misadventures, Edward learns firsthand the savage cruelty of English laws against the poor, while Tom learns the heavy burdens of royal governance...""",
            summary = "A classic historical satire where lookalike boys—beggar Tom Canty and Crown Prince Edward Tudor—swap clothes and roles in Tudor England, experiencing the stark contrast between palace luxury and the brutal reality of London's slums.",
            contextBackground = "Written by Mark Twain in 1881. Explores social stratification, arbitrary justice, and the transformative power of empathy in leadership.",
            keyThemes = listOf("Appearance vs Worth", "Social Justice & Cruelty of the Law", "Empathy Through Shared Suffering"),
            techniques = listOf(
                TechniqueAnalysis("Doppelgänger / Role Reversal", "Prince and Pauper exchange clothes", "Proves that class distinctions are superficial constructs defined purely by costume and privilege."),
                TechniqueAnalysis("Picaresque Journey", "Prince Edward's wanderings with Miles Hendon", "Exposes the Prince to public floggings, debtors' prisons, and tyrannical laws, forging a just future king.")
            ),
            characters = listOf(
                CharacterProfile("Prince Edward", "Rightful heir to Henry VIII", listOf("Dignified", "Courageous", "Just"), "Learns true compassion through being abused as an impoverished vagrant."),
                CharacterProfile("Tom Canty", "Beggarly boy from Offal Court", listOf("Kind", "Imaginative", "Wise"), "Uses innate decency and common sense to reform unjust royal verdicts.")
            ),
            goldenQuotes = listOf(
                GoldenQuote("What dost thou know of suffering and oppression? I and my people know, but not thou.", "Edward VI to his councillors", "Emphasizes that true governance requires experiential understanding of the people's pain.", listOf("Justice", "Kingship"))
            ),
            contextQuestions = listOf(),
            essayPrompts = listOf(
                EssayPromptItem(
                    id = "essay_prince_1",
                    workTitle = "The Prince and the Pauper",
                    genre = LiteraryGenre.NOVEL,
                    title = "Twain's Critique of English Social Hierarchy",
                    prompt = "How does Twain use the switching of identities in 'The Prince and the Pauper' to attack social inequality?",
                    keyPoints = listOf("Superficiality of clothes defining status", "Brutality of Tudor vagrancy laws", "Tom Canty's humane judgements in court", "Edward's moral growth into a benevolent ruler"),
                    peelStructure = "Point: Clothes are shown to be the sole determinant of human status.\nEvidence: Edward is beaten and thrown out of his own palace merely for wearing rags.\nExplanation: Highlights the blindness of institutions that judge humanity by appearance.\nLink: Urges radical empathy and systemic reform.",
                    modelEssaySample = "Mark Twain's 'The Prince and the Pauper' is far more than a charming children's fable..."
                )
            )
        ),
        LiteraryWork(
            id = "novel_tony",
            title = "Bringing Tony Home",
            author = "Tissa Abeysekara",
            genre = LiteraryGenre.NOVEL,
            category = ThemeCategory.TRAGEDY_LOSS,
            grade = 10,
            term = 2,
            fullTextOrExcerpt = """The story follows a young boy during the decline of his aristocratic family in 1930s colonial Ceylon. As their economic status collapses, the family is forced to abandon their ancestral home and move to a modest rented house.
Tony, the beloved golden-brown pet dog, is left behind. The boy undertakes a long, exhausting, heart-wrenching trek across the countryside to bring Tony to their new home, navigating rain, fear, and the painful transition into adulthood...""",
            summary = "A poignant Sri Lankan novella capturing the heartbreak of childhood, the collapse of an aristocratic feudal family, and a young boy's agonizing emotional journey to retrieve his loyal dog Tony.",
            contextBackground = "Written by master Sri Lankan filmmaker and writer Tissa Abeysekara, winning the Gratiaen Prize. Rich in evocative landscape descriptions and sensitive psychological insight.",
            keyThemes = listOf("Loss of Innocence", "Decline of Social Status", "Unconditional Animal Companionship", "Memory & Nostalgia"),
            techniques = listOf(
                TechniqueAnalysis("Lyrical Autobiographical Prose", "Descriptions of the Kelani Valley railway and countryside", "Creates deep nostalgic warmth juxtaposed with personal economic humiliation."),
                TechniqueAnalysis("Symbolism of Tony", "The pet dog Tony", "Symbolizes pure childhood innocence, security, and emotional constancy amid family turmoil.")
            ),
            characters = listOf(
                CharacterProfile("The Boy (Narrator)", "Sensitive adolescent", listOf("Devoted", "Observant", "Vulnerable"), "Experiences the painful realization of adult poverty and helplessness through his love for Tony."),
                CharacterProfile("Tony", "Beloved family dog", listOf("Loyal", "Gentle", "Enduring"), "Represents unconditional loyalty and the last anchor of childhood happiness.")
            ),
            goldenQuotes = listOf(
                GoldenQuote("The rain was falling softly on the rubber trees, and I knew that nothing would ever be quite the same again.", "The Journey", "Reflects the melancholic realization that the world of childhood security has vanished.", listOf("Nostalgia", "Innocence"))
            ),
            contextQuestions = listOf(),
            essayPrompts = listOf(
                EssayPromptItem(
                    id = "essay_tony_1",
                    workTitle = "Bringing Tony Home",
                    genre = LiteraryGenre.NOVEL,
                    title = "Nostalgia and Loss in 'Bringing Tony Home'",
                    prompt = "Examine how Tissa Abeysekara portrays the painful journey from innocence to maturity through the bond between the boy and his dog.",
                    keyPoints = listOf("Family financial decay as background", "The physical journey as a rite of passage", "Tony as an emblem of lost paradise", "The poignant, sensory depiction of rural Ceylon"),
                    peelStructure = "Point: The boy's journey to retrieve Tony mirrors his internal journey into maturity.\nEvidence: His endurance through rain and fatigue without adult assistance.\nExplanation: Proves his growing independence and the burden of grief.\nLink: Anchors the emotional gravity of the novella.",
                    modelEssaySample = "In 'Bringing Tony Home', Tissa Abeysekara crafts an exquisitely tender Sri Lankan masterpiece..."
                )
            )
        ),
        LiteraryWork(
            id = "novel_vendor",
            title = "The Vendor of Sweets",
            author = "R.K. Narayan",
            genre = LiteraryGenre.NOVEL,
            category = ThemeCategory.LIFE,
            grade = 10,
            term = 2,
            fullTextOrExcerpt = """Jagan, a vendor of sweets in the fictional South Indian town of Malgudi, prides himself on strict adherence to Gandhian principles, non-violence, and naturopathy, while accumulating immense piles of untaxed cash ('free cash') from his shop.
His sheltered world unravels when his spoiled, westernized son Mali returns from America with a Korean-American companion, Grace, and an absurd, expensive business scheme to manufacture a 'novel-writing machine'...""",
            summary = "A humorous yet poignant tragicomedy exploring the generational, cultural, and spiritual chasm between an eccentric Gandhian sweet-vendor father, Jagan, and his alienated modern son, Mali, set in Malgudi.",
            contextBackground = "Written by R.K. Narayan in 1967. Explores the collision between traditional Hindu ideals (and the fourth stage of life, Vanaprastha) and western commercial modernity.",
            keyThemes = listOf("Generational Conflict & Communication Breakdown", "Tradition vs Western Modernity", "Parental Blindness & Spiritual Renunciation"),
            techniques = listOf(
                TechniqueAnalysis("Subtle Gentle Irony", "Jagan's Gandhian austerity vs his hoard of secret cash", "Exposes the benign hypocrisies of human nature where spiritual piety coexists with money-making."),
                TechniqueAnalysis("The 'Story-Writing Machine' Symbol", "Mali's absurd mechanical writing apparatus", "Satirizes modern mechanistic consumerism replacing genuine creative human culture.")
            ),
            characters = listOf(
                CharacterProfile("Jagan", "Vendor of sweets", listOf("Pious", "Eccentric", "Devoted father"), "Wrestles with fatherly attachment before achieving philosophical detachment."),
                CharacterProfile("Mali", "Alienated westernized son", listOf("Ambitious", "Disrespectful", "Entitled"), "Disdains his father's traditional lifestyle and seeks shortcuts to wealth.")
            ),
            goldenQuotes = listOf(
                GoldenQuote("Everything must have a name, but the truth is nameless.", "Jagan's Musings", "Reflects Jagan's philosophical search for peace beyond domestic entanglements.", listOf("Philosophy", "Detachment"))
            ),
            contextQuestions = listOf(),
            essayPrompts = listOf(
                EssayPromptItem(
                    id = "essay_vendor_1",
                    workTitle = "The Vendor of Sweets",
                    genre = LiteraryGenre.NOVEL,
                    title = "Tradition vs Modernity in 'The Vendor of Sweets'",
                    prompt = "Discuss how R.K. Narayan uses the father-son relationship in 'The Vendor of Sweets' to explore cultural clash and detachment.",
                    keyPoints = listOf("Jagan's Gandhian ideals and contradictions", "Mali's Americanized consumer ambitions", "The inability of father and son to communicate honestly", "Jagan's final choice to retreat into spiritual serenity"),
                    peelStructure = "Point: The gulf between Jagan and Mali symbolizes India's transitional identity crisis.\nEvidence: Mali's rejection of sweet-making for a motorized novel-writing machine.\nExplanation: Shows traditional craftsmanship displaced by foreign commercial illusions.\nLink: Illuminates the tragicomedy of family disintegration.",
                    modelEssaySample = "In 'The Vendor of Sweets', R.K. Narayan masterfully dramatizes the quiet tragedy of the generation gap..."
                )
            )
        )
    )
}
