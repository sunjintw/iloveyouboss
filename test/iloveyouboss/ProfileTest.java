package iloveyouboss;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by jsun on 1/14/16.
 */
public class ProfileTest {

    @Test
    public void return_false_when_matches_with_empty_criteria() {
        Profile profile = new Profile("Test");
        Criteria criteria = new Criteria();

        boolean result = profile.matches(criteria);

        assertThat(result, not(true));
    }

    @Test
    public void return_true_when_criterion_weight_is_dont_care() {
        Profile profile = new Profile("Test");
        Answer answer = new Answer(new Question(0, null, null) {
            @Override
            public boolean match(int expected, int actual) {
                return false;
            }
        }, 0);
        Criterion criterion = new Criterion(answer, Weight.DontCare);
        Criteria criteria = new Criteria();
        criteria.add(criterion);

        boolean result = profile.matches(criteria);
        assertThat(result, is(true));
    }
}