package danilk.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import danilk.models.NewsModel;
import com.example.danilk.metasapp.R;

import java.util.List;

/**
 * Created by dan on 1/18/16.
 */
public class RecyclerAdapterNews extends RecyclerView.Adapter<RecyclerAdapterNews.ViewHolder> {

    private List<NewsModel> news;

    public RecyclerAdapterNews(List<NewsModel> news){
        this.news = news;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{ // made static for Firbase UI

        CardView cv;
        public TextView titleNews;
        public TextView contentNews;
        public TextView linkNews;

        public ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_news);
            titleNews = (TextView)itemView.findViewById(R.id.card_title_news);
            contentNews = (TextView)itemView.findViewById(R.id.card_content_news);
            linkNews = (TextView) itemView.findViewById(R.id.card_content_link);
        }
    }
    ////////////////
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    ////////////

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_news,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleNews.setText(news.get(position).titleNews);
        holder.contentNews.setText(news.get(position).contentNews);
        holder.linkNews.setText(news.get(position).linkNews);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }


}
