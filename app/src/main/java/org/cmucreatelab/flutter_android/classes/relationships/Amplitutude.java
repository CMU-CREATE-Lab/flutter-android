package org.cmucreatelab.flutter_android.classes.relationships;

import org.cmucreatelab.flutter_android.R;

/**
 * Created by Steve on 8/11/2016.
 *
 * Amplitude
 *
 * A class that represents an amplitude relationship.
 *
 */
public class Amplitutude implements Relationship {

    private static final Relationship.Type relationshipType = Type.AMPLITUDE;
    public static final int greenImageId = R.drawable.relationship_green_amplitude;



    @Override
    public Type getRelationshipType() {
        return relationshipType;
    }


    @Override
    public int getGreenImageId() {
        return 0;
    }

}
