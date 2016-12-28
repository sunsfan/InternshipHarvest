package sunsfa_storm.topology;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;
import sunsfan_storm.bolt.WorldBolt;
import sunsfan_storm.spout.WordSpout;

public class WordTopology {
	public static void main(String[] args) throws InterruptedException {
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("word-spout", new WordSpout());
		builder.setBolt("word-bolt", new WorldBolt()).shuffleGrouping("word-spout");

		Config conf = new Config();
		// conf.put("wordsFile", "D:\\dorm_test\\words1.txt");
		//conf.setDebug(false);

		//conf.put(Config.TOPOLOGY_MAX_SPOUT_PENDING, 1);
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("Getting-Started-Topologie", conf, builder.createTopology());
		Thread.sleep(99999);
		cluster.shutdown();
	}
}
