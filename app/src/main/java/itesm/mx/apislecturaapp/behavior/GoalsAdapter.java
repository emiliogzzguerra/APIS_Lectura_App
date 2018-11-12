package itesm.mx.apislecturaapp.behavior;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import itesm.mx.apislecturaapp.Database.LibraryOperations;
import itesm.mx.apislecturaapp.R;
import itesm.mx.apislecturaapp.model.Goal;
import itesm.mx.apislecturaapp.model.Book;

public class GoalsAdapter extends RecyclerView.Adapter<GoalsAdapter.ViewHolder> {

    private List<Goal> mGoals;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private LibraryOperations lop;
    private Context context;

    // data is passed into the constructor
    public GoalsAdapter(Context context, List<Goal> goals) {
        this.mInflater = LayoutInflater.from(context);
        this.mGoals = goals;
        this.context = context;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.goal_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        lop = new LibraryOperations(this.context);
        lop.open();

        Goal goal = mGoals.get(position);
        Book book = lop.findBook(goal.getBookId());

        lop.close();

        holder.mBookCover.setImageResource(book.getCoverThumbId());
        holder.mGoalTitle.setText(book.getTitle());
        holder.mPagesForToday.setText("Paginas por leer hoy: " + goal.getPagesPerDay());
        holder.mReadingStreak.setText("Racha lectura: " + (int) (Math.random() * 10 + 1));
        holder.mRemainingPages.setText("Paginas restantes: " + goal.getRemainingPages());
        holder.mTargetDate.setText("Fecha objectivo: " + goal.getTargetDate());
        holder.mGoalProgress.setMin(0);
        holder.mGoalProgress.setProgress(goal.getProgress());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mGoals.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView mBookCover;
        TextView mGoalTitle;
        TextView mTargetDate;
        TextView mPagesForToday;
        TextView mReadingStreak;
        TextView mRemainingPages;
        ProgressBar mGoalProgress;

        ViewHolder(View itemView) {
            super(itemView);
            mBookCover = itemView.findViewById(R.id.goal_book_cover_img);
            mGoalTitle = itemView.findViewById(R.id.goal_title);
            mTargetDate = itemView.findViewById(R.id.target_date);
            mPagesForToday = itemView.findViewById(R.id.pages_for_today);
            mReadingStreak = itemView.findViewById(R.id.reading_streak);
            mRemainingPages = itemView.findViewById(R.id.remaining_pages);
            mGoalProgress = itemView.findViewById(R.id.goal_progress);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public Goal getGoal(int id) {
        return mGoals.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}