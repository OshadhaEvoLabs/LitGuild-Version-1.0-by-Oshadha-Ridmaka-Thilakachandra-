package com.example.data.repository

import com.example.data.model.*

object ProseData {
    val proseWorks: List<LiteraryWork> = listOf(
        LiteraryWork(
            id = "prose_nightingale",
            title = "The Nightingale and the Rose",
            author = "Oscar Wilde",
            genre = LiteraryGenre.PROSE,
            category = ThemeCategory.GREED_LOVE,
            grade = 10,
            term = 2,
            fullTextOrExcerpt = """“SHE said that she would dance with me if I brought her red roses,” cried the young Student, “but in all my garden there is no red rose.”
From her nest in the holm-oak tree the Nightingale heard him, and she looked out through the leaves, and wondered.
“Here at last is a true lover,” said the Nightingale...
“Death is a great price to pay for a red rose,” cried the Nightingale, “and Life is very dear to all... Yet Love is better than Life, and what is the heart of a bird compared to the heart of a man?”
So she sang with her breast against the thorn, and her life-blood ebbed away...
At noon the Student opened his window and found the rose. He took it to the Professor's daughter, but she frowned: “I am afraid it will not go with my dress; and, besides, the Chamberlain's nephew has sent me some real jewels, and everybody knows that jewels cost far more than flowers.”
“What a silly thing Love is,” said the Student as he walked away. “It is not half as useful as Logic... I shall go back to Philosophy and study Metaphysics.”""",
            summary = "A fairy tale satirizing superficiality and materialism. A romantic Nightingale sacrifices her life by pressing her heart against a rose thorn to produce a red rose for a student. The girl rejects the flower for jewels, and the student discards the blood-bought rose into the gutter, dismissing love as unpractical.",
            contextBackground = "Written by Oscar Wilde in 'The Happy Prince and Other Tales' (1888). Critiques Victorian utilitarianism, commodification of affection, and the blindness of academic pedantry.",
            keyThemes = listOf("Idealism vs Materialism", "True Sacrifice vs Superficial Infatuation", "The Tragedy of Unappreciated Devotion"),
            techniques = listOf(
                TechniqueAnalysis("Irony / Bathos", "Student throws rose into gutter: 'What a silly thing Love is... I shall go back to Philosophy'", "Severe situational irony where supreme, mystical martyrdom is instantly cheapened and discarded for practical logic."),
                TechniqueAnalysis("Fairy Tale Allegory", "Nightingale as Christ-like artist", "Pressing her heart to a thorn symbolizes the artist's total self-giving sacrifice for sublime beauty and love."),
                TechniqueAnalysis("Color Symbolism", "White to Pink to Crimson rose", "The deepening color of the rose mirrors the escalating cost of life-blood drained from the bird.")
            ),
            characters = listOf(
                CharacterProfile("The Nightingale", "Selfless romantic artist", listOf("Idealistic", "Noble", "Self-sacrificing"), "Believes love is wiser than philosophy and dies so love may triumph."),
                CharacterProfile("The Student", "Callow pseudo-intellectual", listOf("Fickle", "Self-absorbed", "Prone to despair"), "Claims to understand philosophy but has zero capacity for emotional depth."),
                CharacterProfile("The Professor's Daughter", "Vain socialite", listOf("Materialistic", "Superficial", "Snobbish"), "Values suitors by silver shoe buckles and expensive jewels.")
            ),
            goldenQuotes = listOf(
                GoldenQuote("Love is wiser than Philosophy, though she is wise, and mightier than Power, though he is mighty.", "The Nightingale", "Celebrates the transcendental supremacy of genuine love over cold intellect.", listOf("Love", "Philosophy")),
                GoldenQuote("Yet Love is better than Life, and what is the heart of a bird compared to the heart of a man?", "The Nightingale's Decision", "Tragic misjudgment where the bird values human capacity for love far higher than humans deserve.", listOf("Sacrifice", "Tragedy")),
                GoldenQuote("and he threw the rose into the street, where it fell into the gutter, and a cart-wheel went over it.", "The Student's Rejection", "Visual image of supreme beauty and sacrifice crushed by callous mundanity.", listOf("Bathos", "Irony"))
            ),
            contextQuestions = listOf(
                ContextQuestionItem(
                    id = "ctx_nightingale_1",
                    workTitle = "The Nightingale and the Rose",
                    author = "Oscar Wilde",
                    extractQuote = "“I am afraid it will not go with my dress,” she answered; ‘and, besides, the Chamberlain’s nephew has sent me some real jewels, and everybody knows that jewels cost far more than flowers.”",
                    questionB = "Who speaks these words and to whom?",
                    questionC = "What has the other person just brought to her?",
                    questionD = "What does the speaker's response reveal about her character and values?",
                    modelAnswerA = "From the short story 'The Nightingale and the Rose' by Oscar Wilde.",
                    modelAnswerB = "The Professor's daughter speaks these words to the young Student.",
                    modelAnswerC = "A magnificent crimson red rose, created by the Nightingale at the cost of her life.",
                    modelAnswerD = "She is materialistic, calculating, and shallow. She equates love with monetary value, preferring jewels and social status (the Chamberlain's nephew) over genuine beauty and affection."
                )
            ),
            essayPrompts = listOf(
                EssayPromptItem(
                    id = "essay_nightingale_1",
                    workTitle = "The Nightingale and the Rose",
                    genre = LiteraryGenre.PROSE,
                    title = "Satire and Sacrifice in 'The Nightingale and the Rose'",
                    prompt = "Examine how Oscar Wilde uses irony to expose human shallowness and celebrate self-sacrifice in 'The Nightingale and the Rose'.",
                    keyPoints = listOf("Contrast between the Nightingale's martyrdom and human indifference", "The student's superficial concept of passion", "Wilde's critique of Victorian materialism", "The symbolic fate of the red rose"),
                    peelStructure = "Point: The tragic core of the story lies in the student's inability to comprehend true love.\nEvidence: After being rejected, he cries 'What a silly thing Love is... It is not half as useful as Logic'.\nExplanation: Wilde uses dramatic irony to expose intellectual arrogance masking emotional vacuity.\nLink: Deepens the tragedy of the Nightingale's wasted sacrifice.",
                    modelEssaySample = "In 'The Nightingale and the Rose', Oscar Wilde constructs an exquisite yet cutting critique..."
                )
            )
        ),
        LiteraryWork(
            id = "prose_lumber_room",
            title = "The Lumber Room",
            author = "Saki (H.H. Munro)",
            genre = LiteraryGenre.PROSE,
            category = ThemeCategory.HUMOUR,
            grade = 10,
            term = 1,
            fullTextOrExcerpt = """THE CHILDREN WERE to be driven, as a special treat, to the sands at Jagborough. Nicholas was not to be of the party; he was in disgrace. Only that morning he had refused to eat his wholesome bread-and-milk on the seemingly frivolous ground that there was a frog in it...
The dramatic part of the incident was that there really was a frog in Nicholas's basin... he had put it there himself...
His cousins' aunt, who insisted in styling herself his aunt also, had hastily invented the Jagborough expedition... It was her habit, whenever one of the children fell from grace, to improvise something of a festival nature...
Nicholas slipped into the house... and rapidly put into execution a plan of action... The door opened, and Nicholas was in an unknown land: the lumber-room...
Presently the aunt screamed from the gooseberry garden: 'Nicholas! I've slipped into the rain-water tank... Fetch the ladder!'
'I was told I wasn't to go into the gooseberry garden,' said Nicholas promptly.
'Will there be strawberry jam for tea?'
'Certainly there will be,' said the aunt...
'Now I know you are the Evil One and not aunt! Aunt said there wasn't any strawberry jam yesterday! Oh, Devil, you have sold yourself!'""",
            summary = "A witty comedy of youthful rebellion. Nicholas outsmarts his authoritarian aunt, staging a diversion to explore the forbidden lumber-room of wonders, and later cleverly traps her in her own rigid disciplinary rules when she falls into a water tank.",
            contextBackground = "Written by master satirist Saki (H.H. Munro). Critiques strict, hypocritical Edwardian child-rearing where adults used petty punitive morality to suppress imagination.",
            keyThemes = listOf("Childhood Imagination vs Adult Rigidity", "Hypocrisy of Moralistic Authority", "Triumph of Wit & Tactical Intelligence"),
            techniques = listOf(
                TechniqueAnalysis("Irony / Role Reversal", "Nicholas using the aunt's strict rules to leave her in the rain-water tank", "Poetic justice where the aunt is imprisoned by her own prohibition ('not to enter the gooseberry garden')."),
                TechniqueAnalysis("Satirical Characterization", "'the aunt-by-assertion', 'older, wiser, and better people'", "Saki mocks adult presumption of infallibility with understated mock-solemnity."),
                TechniqueAnalysis("Rich Sensory Imagery", "The tapestry fire-screen, twisted snake candlesticks, bird book", "Contrasts the barren, repressive household with the magical sanctuary of the lumber-room.")
            ),
            characters = listOf(
                CharacterProfile("Nicholas", "Ingenious, imaginative rebel", listOf("Tactical", "Observant", "Witty"), "Master strategist who exposes adult fallibility and revels in wonder."),
                CharacterProfile("The Aunt", "Authoritarian Victorian disciplinarian", listOf("Rigid", "Vindictive", "Hypocritical"), "Invents punitive treats and claims moral superiority, but lacks empathy and wit.")
            ),
            goldenQuotes = listOf(
                GoldenQuote("the older, wiser, and better people had been proved to be profoundly in error in matters about which they had expressed the utmost assurance.", "Narrator on the frog incident", "Foundational premise proving adult authoritarian dogmatism can be completely wrong.", listOf("Adults", "Irony")),
                GoldenQuote("Nicholas did not admit the flawlessness of the reasoning; he felt perfectly capable of being in disgrace and in a gooseberry garden at the same moment.", "Nicholas's Logic", "Delightful subversion of adult moral logic.", listOf("Humour", "Logic")),
                GoldenQuote("Oh, Devil, you have sold yourself!", "Nicholas to the Aunt in the tank", "Climactic rhetorical victory trapping the aunt in her own theological warnings.", listOf("Triumph", "Wit"))
            ),
            contextQuestions = listOf(
                ContextQuestionItem(
                    id = "ctx_lumber_1",
                    workTitle = "The Lumber Room",
                    author = "Saki (H.H. Munro)",
                    extractQuote = "‘Now I know that you are the Evil One and not aunt,’ shouted Nicholas gleefully; ‘when we asked aunt for strawberry jam yesterday she said there wasn’t any. I know there are four jars of it in the store cupboard... Oh, Devil, you have sold yourself!’",
                    questionB = "Where is the aunt when Nicholas says this?",
                    questionC = "Why does Nicholas call her the 'Evil One'?",
                    questionD = "How does this episode demonstrate Nicholas's cleverness and the aunt's hypocrisy?",
                    modelAnswerA = "From 'The Lumber Room' by Saki (H.H. Munro).",
                    modelAnswerB = "She is trapped inside the empty, slippery rain-water tank in the gooseberry garden.",
                    modelAnswerC = "The aunt had previously lectured him that the Evil One tempts children to disobedience; Nicholas wittily pretends the voice in the tank is the devil offering forbidden jam.",
                    modelAnswerD = "Nicholas brilliantly turns the aunt's moralistic preaching against her while exposing her lie (she claimed there was no jam when four jars were hidden in the cupboard)."
                )
            ),
            essayPrompts = listOf(
                EssayPromptItem(
                    id = "essay_lumber_1",
                    workTitle = "The Lumber Room",
                    genre = LiteraryGenre.PROSE,
                    title = "The Conflict Between Childhood and Adult Authority",
                    prompt = "How does Saki portray Nicholas as a hero against the oppressive authority of his aunt in 'The Lumber Room'?",
                    keyPoints = listOf("The aunt's vindictive parenting ('punitive expeditions')", "Nicholas's superior intellect and planning", "The contrast between the dreary house and magical lumber-room", "The poetic justice of the resolution"),
                    peelStructure = "Point: Saki depicts adult authority as hypocritical and dull.\nEvidence: The aunt's 'habit... to improvise something of a festival nature from which the offender would be rigorously debarred'.\nExplanation: Discipline is revealed as spiteful manipulation rather than moral teaching.\nLink: Nicholas's rebellion becomes an admirable assertion of individuality.",
                    modelEssaySample = "In 'The Lumber Room', Saki offers a delightful yet sharp satire of Edwardian domestic tyranny..."
                )
            )
        ),
        LiteraryWork(
            id = "prose_lahore",
            title = "The Lahore Attack (from Colin Cowdrey Lecture)",
            author = "Kumar Sangakkara",
            genre = LiteraryGenre.PROSE,
            category = ThemeCategory.CRICKET_RESILIENCE,
            grade = 10,
            term = 1,
            fullTextOrExcerpt = """Not thirty seconds had passed when we heard what sounded like fire crackers going off. Suddenly a shout came from the front: “Get down they are shooting at the bus.”
Then the bullets started to hit. It was like rain on a tin roof. The bus was at a standstill, an easy target for the gunmen...
Tharanga Paranavithana, on his debut tour, is also next to me. He stands up, bullets flying all around him, shouting “I have been hit” as he holds his blood-soaked chest. He collapsed onto his seat, apparently unconscious.
I see him and I think: “Oh my God, you were out first ball, run out the next innings and now you have been shot. What a terrible first tour.”
We all sit in the dressing room and talk... Within minutes there is laughter and the jokes have started to flow. We have for the first time been a target of violence. We had survived...
A week after our arrival in Colombo... A soldier politely inquired as to my health... He replied: “It is OK if I die because it is my job and I am ready for it. But you are a hero and if you were to die it would be a great loss for our country.”
I was taken aback. How can this man value his life less than mine? His sincerity was overwhelming. I felt humbled.""",
            summary = "A gripping firsthand memoir excerpt from Kumar Sangakkara's historic MCC Spirit of Cricket Cowdrey Lecture (2011), detailing the 2009 terrorist ambush on the Sri Lankan cricket bus in Lahore, the brotherhood of survival, and a humbling encounter with a Sri Lankan soldier.",
            contextBackground = "Delivered at Lord's in 2011 by former Sri Lankan cricket captain Kumar Sangakkara. The speech won international acclaim for its literary grace, national healing, and moral humility.",
            keyThemes = listOf("Resilience Under Fire", "Brotherhood & Humour in Crisis", "True Heroism vs Sporting Fame", "National Identity"),
            techniques = listOf(
                TechniqueAnalysis("Sensory Simile", "'It was like rain on a tin roof'", "Evokes the terrifying volume and continuous barrage of assault rifle bullets penetrating the bus."),
                TechniqueAnalysis("Surreal Humour / Coping Mechanism", "Sangakkara's thought regarding Paranavithana's debut tour", "Captures how the human mind grasps mundane sporting thoughts amid mortal terror to stave off panic."),
                TechniqueAnalysis("Climactic Encounter / Epiphany", "Dialogue with the checkpoint soldier", "Subverts the public definition of 'hero', showing the profound humility of real soldiers who sacrifice daily.")
            ),
            characters = listOf(
                CharacterProfile("Kumar Sangakkara", "Narrator / Cricketer", listOf("Reflective", "Courageous", "Humble"), "Undergoes an epiphany regarding real courage and national duty."),
                CharacterProfile("The Checkpoint Soldier", "Sri Lankan serviceman", listOf("Selfless", "Devoted", "Humble"), "Views his own life as expendable for his country while revering national sportsmen.")
            ),
            goldenQuotes = listOf(
                GoldenQuote("Then the bullets started to hit. It was like rain on a tin roof.", "The Ambush", "Iconic simile describing the suddenness and density of terrorist fire.", listOf("Violence", "Sensory")),
                GoldenQuote("We were not down and out. 'We are Sri Lankan,' we thought to ourselves, 'and we are tough and we will get through hardship and we will overcome because our spirit is strong.'", "Reflections in Lahore", "Declaration of collective national endurance in the face of calamity.", listOf("Patriotism", "Strength")),
                GoldenQuote("How can this man value his life less than mine? His sincerity was overwhelming. I felt humbled.", "Checkpoint Epiphany", "Core thematic realization differentiating celebrity adoration from genuine service.", listOf("Humility", "Heroism"))
            ),
            contextQuestions = listOf(
                ContextQuestionItem(
                    id = "ctx_lahore_1",
                    workTitle = "The Lahore Attack",
                    author = "Kumar Sangakkara",
                    extractQuote = "“It is OK if I die because it is my job and I am ready for it. But you are a hero and if you were to die it would be a great loss for our country.”",
                    questionB = "Who says this and to whom?",
                    questionC = "What event had taken place recently to prompt this conversation?",
                    questionD = "What effect did these words have on the listener?",
                    modelAnswerA = "From 'The Lahore Attack' (Colin Cowdrey Lecture) by Kumar Sangakkara.",
                    modelAnswerB = "A Sri Lankan army soldier at a security checkpoint in Colombo speaks to Kumar Sangakkara.",
                    modelAnswerC = "The Sri Lankan national cricket team had just survived the terrorist ambush in Lahore, Pakistan, in 2009.",
                    modelAnswerD = "The listener (Sangakkara) was profoundly humbled and astonished. It forced him to re-evaluate the inflated status of sports celebrities compared to frontline servicemen who sacrifice their lives quietly."
                )
            ),
            essayPrompts = listOf(
                EssayPromptItem(
                    id = "essay_lahore_1",
                    workTitle = "The Lahore Attack",
                    genre = LiteraryGenre.PROSE,
                    title = "The Definition of Courage in Sangakkara's Speech",
                    prompt = "How does Kumar Sangakkara explore the concept of heroism, vulnerability, and national spirit in 'The Lahore Attack'?",
                    keyPoints = listOf("Physical vulnerability inside the trapped bus", "Mental fortitude and humor as survival tactics", "Empathy developed for fellow citizens who endured civil war", "The contrast between athletic fame and true military sacrifice"),
                    peelStructure = "Point: Sangakkara deconstructs the conventional mythology of sporting heroes.\nEvidence: His reflection on the soldier: 'How can this man value his life less than mine?'.\nExplanation: He contrasts the superficial applause of cricket fans with the selfless devotion of ordinary soldiers.\nLink: Affirms authentic national character.",
                    modelEssaySample = "In his Cowdrey Lecture, Kumar Sangakkara transcends the boundaries of cricket journalism..."
                )
            )
        ),
        LiteraryWork(
            id = "prose_wave",
            title = "Wave: A Memoir of Life after the Tsunami",
            author = "Sonali Deraniyagala",
            genre = LiteraryGenre.PROSE,
            category = ThemeCategory.TRAGEDY_LOSS,
            grade = 10,
            term = 3,
            fullTextOrExcerpt = """It was then she saw the wave. “Oh my God, the sea’s coming in.” That’s what she said. I looked behind me. It didn’t seem that remarkable. Or alarming. It was only the white curl of a big wave...
Then there was more white froth. And more... All these waves now, charging, churning. Suddenly furious. Suddenly menacing. “Steve, you’ve got to come out. Now.”
I grabbed Vik and Malli, and we all ran out the front door... I didn’t stop for my parents. I didn’t stop to knock on the door of my parents' room... It will stall us. We must keep running.
Ahead of us a jeep was moving... We ran up to it. I flung Vikram into the back...
The jeep was in water then. Suddenly, all this water inside the jeep. Water sloshing over our knees... We were tilting from side... Steve held Vik, I had Mal.
Then I saw Steve's face. I'd never seen him like that before. A sudden look of terror, eyes wide open, mouth agape...
Because it turned over. The jeep turned over. On my side...
Am I underwater? It didn't feel like water, but it has to be, I thought.""",
            summary = "A harrowing, breathless eyewitness account of the 2004 Indian Ocean Tsunami striking Yala National Park, Sri Lanka, where the narrator lost her husband Steve, two young sons (Vik and Malli), and parents.",
            contextBackground = "Written by Sri Lankan economist Sonali Deraniyagala, 'Wave' won the PEN/Ackerley Prize. It depicts the abrupt transformation of a serene tropical vacation into devastating catastrophe.",
            keyThemes = listOf("Unfathomable Loss & Grief", "The Fragility of Life", "Instinctual Survival & Maternal Torment"),
            techniques = listOf(
                TechniqueAnalysis("Short, Staccato Sentences", "'We had no time. We had to be fast. I knew that.'", "Mirrors panic, accelerated heartbeat, and fragmented consciousness during an unimaginable natural catastrophe."),
                TechniqueAnalysis("Sensory Transformation of Nature", "From 'glint of blue' and 'white curl' to 'charging, churning... smoky and gray'", "Reflects the terrifying transition of the sea from peaceful beauty into lethal, monstrous destruction."),
                TechniqueAnalysis("Visceral Guilt & Regret", "'I didn't stop for my parents... As I ran past, for a splintered second, I wondered'", "Captures the psychological agony of split-second survival decisions that haunt survivors forever.")
            ),
            characters = listOf(
                CharacterProfile("Sonali (Narrator)", "Mother / Survivor", listOf("Frantic", "Loving", "Traumatized"), "Acts purely on fierce maternal instinct to save her children before the catastrophic flood."),
                CharacterProfile("Steve", "Husband / Father", listOf("Protective", "Calming", "Loving"), "Attempts to comfort the boys ('Aachchi and seeya will be okay') until the wall of water hits.")
            ),
            goldenQuotes = listOf(
                GoldenQuote("Suddenly furious. Suddenly menacing. 'Steve, you've got to come out. Now.'", "Arrival of the Tsunami", "Pivotal turning point where casual curiosity converts into stark mortal peril.", listOf("Danger", "Tsunami")),
                GoldenQuote("I didn't stop for my parents. I didn't stop to knock on the door of my parents' room... It will stall us. We must keep running.", "Split-second flight", "The unbearable agony of survival triage in the face of imminent doom.", listOf("Grief", "Instinct")),
                GoldenQuote("Then I saw Steve’s face. I’d never seen him like that before. A sudden look of terror, eyes wide open, mouth agape.", "Final Glimpse", "The terrifying final visual memory before the vehicle overturns.", listOf("Terror", "Memory"))
            ),
            contextQuestions = listOf(
                ContextQuestionItem(
                    id = "ctx_wave_1",
                    workTitle = "Wave: A Memoir of Life after the Tsunami",
                    author = "Sonali Deraniyagala",
                    extractQuote = "Then I saw Steve’s face. I’d never seen him like that before. A sudden look of terror, eyes wide open, mouth agape. He saw something behind me that I couldn’t see. I didn’t have time to turn around and look.\nBecause it turned over. The jeep turned over. On my side.",
                    questionB = "Who is Steve and where are they when this occurs?",
                    questionC = "What did Steve see that the narrator could not see?",
                    questionD = "How does the author's writing style create a sense of panic and helplessness?",
                    modelAnswerA = "Taken from 'Wave: A Memoir of Life after the Tsunami' by Sonali Deraniyagala.",
                    modelAnswerB = "Steve is the narrator's husband; they are inside a safari jeep fleeing the tsunami near Yala National Park.",
                    modelAnswerC = "The towering, catastrophic wall of ocean water / tsunami wave cresting directly behind the jeep.",
                    modelAnswerD = "Short, clipped sentences ('Because it turned over. On my side.') and raw sensory impressions capture the sudden, disorienting shock without decorative sentimentality."
                )
            ),
            essayPrompts = listOf(
                EssayPromptItem(
                    id = "essay_wave_1",
                    workTitle = "Wave: A Memoir of Life after the Tsunami",
                    genre = LiteraryGenre.PROSE,
                    title = "The Portrayal of Shock and Maternal Love in 'Wave'",
                    prompt = "Discuss how Sonali Deraniyagala conveys the suddenness of catastrophe and maternal desperation in 'Wave'.",
                    keyPoints = listOf("Deceptive peacefulness of the morning", "Escalating tempo of verbs and sentences", "Fierce focus on protecting the children at all costs", "Psychological trauma and haunting regret"),
                    peelStructure = "Point: Deraniyagala depicts maternal instinct overriding all conscious calculation.\nEvidence: 'I held the boys each by the hand... Give me one of them, Steve shouted... But I didn't. That would have slowed us down.'\nExplanation: Her singular devotion to gripping her children illustrates raw parental protectiveness.\nLink: Amplifies the heart-wrenching tragedy of what follows.",
                    modelEssaySample = "Sonali Deraniyagala's 'Wave' is an extraordinary testament to the brutality of nature..."
                )
            )
        )
    )
}
