package sunsfan_storm.bolt;

import java.util.Collection;
import java.util.Map;

import DBUtils.DBUtil;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

public class WorldBolt extends BaseRichBolt {
	private TopologyContext context;
	private OutputCollector collector;
	private Map conf;

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this.conf = stormConf;
		this.context = context;
		this.collector = collector;
	}

	@Override
	public void execute(Tuple input) {
		String sentence = input.getString(0);
		String[] words = sentence.split("\\s");
		for (String word : words) {
			// System.out.println(word);
			DBUtil.saveWord(word);
		}
		collector.ack(input);
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub

	}

}
