package sunsfan_storm.spout;

import java.util.Map;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

public class WordSpout extends BaseRichSpout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TopologyContext context;
	private SpoutOutputCollector collector;
	private String sentence = "The quick brown fox jumps over the lazy dog";
	private Map conf;
	private boolean flag = true;

	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		this.conf = conf;
		this.context = context;
		this.collector = collector;
	}

	@Override
	public void nextTuple() {
		while (flag) {
			this.collector.emit(new Values(sentence));
			flag = false;
		}
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("sentence"));
	}

}
