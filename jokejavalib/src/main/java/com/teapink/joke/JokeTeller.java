package com.teapink.joke;

import java.util.Random;

public class JokeTeller {

    private String[] jokeArray = {"Today a man knocked on my door and asked for a small donation towards the local swimming pool. I gave him a glass of water.",
            "I asked God for a bike, but I know God doesn't work that way. So I stole a bike and asked for forgiveness.",
            "Just read that 4,153,237 people got married last year, not to cause any trouble but shouldn't that be an even number?",
            "A recent study has found that women who carry a little extra weight live longer than the men who mention it.",
            "Strong people don't put others down. They lift them up and slam them on the ground for maximum damage.",
            "Child's experience: if a mother is laughing at the fathers jokes, it means they have guests.",
            "I want to die peacefully in my sleep, like my grandfather.. Not screaming and yelling like the passengers in his car.",
            "My wife and I were happy for twenty years. Then we met.",
            "That awkward moment when you leave a store without buying anything and all you can think is \"act natural, you're innocent\".",
            "I think my neighbor is stalking me as she's been googling my name on her computer. I saw it through my telescope last night."};


    public String tellJoke() {
        int index = new Random().nextInt(jokeArray.length);
        return jokeArray[index];
    }
}
