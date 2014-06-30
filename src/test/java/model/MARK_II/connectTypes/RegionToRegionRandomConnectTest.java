package model.MARK_II.connectTypes;

import junit.framework.TestCase;
import model.MARK_II.Column;
import model.MARK_II.Region;

/**
 * @author Quinn Liu (quinnliu@vt.edu)
 * @version April 19th, 2014
 */
public class RegionToRegionRandomConnectTest extends TestCase {
    private AbstractRegionToRegionConnect connectType;
    private Region parentRegion;
    private Region childRegion;

    public void setUp() {
        this.connectType = new RegionToRegionRandomConnect();
        this.parentRegion = new Region("parentRegion", 8, 8, 1, 20, 3);
        this.childRegion = new Region("childRegion", 66, 66, 1, 20, 3);
    }

    public void test_ConnectWithNoOverlap() {
        this.connectType.connect(this.childRegion, this.parentRegion, 2, 2);

        Column[][] columns = this.parentRegion.getColumns();
        for (int parentColumnRowPosition = 0; parentColumnRowPosition < this.parentRegion
                .getXAxisLength(); parentColumnRowPosition++) {
            for (int parentColumnColumnPosition = 0; parentColumnColumnPosition < this.parentRegion
                    .getYAxisLength(); parentColumnColumnPosition++) {
                assertEquals(72, columns[parentColumnRowPosition][parentColumnColumnPosition]
                        .getProximalSegment().getSynapses().size());
            }
        }
    }
}
